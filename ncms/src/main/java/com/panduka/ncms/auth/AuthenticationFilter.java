package com.panduka.ncms.auth;

import com.panduka.ncms.entity.User;
import com.panduka.ncms.exception.InvalidJwtException;
import com.panduka.ncms.exception.UserNotFoundException;
import com.panduka.ncms.services.hospital.UserService;
import com.panduka.ncms.services.hospital.UserServiceImpl;

import java.lang.reflect.Method;

import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import java.util.List;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Provider public class AuthenticationFilter implements ContainerRequestFilter {

    private static final Logger logger = LogManager.getLogger(AuthenticationFilter.class);
    private static final String AUTHORIZATION_PROPERTY = "Authorization";

    @Context private ResourceInfo resourceInfo;

    @Override public void filter(ContainerRequestContext requestContext) {

        Method method = resourceInfo.getResourceMethod();

        // everybody can access (e.g. user/create or user/authenticate)
        if (!method.isAnnotationPresent(PermitAll.class)) {
            // nobody can access
            if (method.isAnnotationPresent(DenyAll.class)) {
                requestContext.abortWith(
                        Response.status(Response.Status.FORBIDDEN).entity("Access blocked for all users !!").build());
                return;
            }

            // get request headers to extract jwt token
            final MultivaluedMap<String, String> headers = requestContext.getHeaders();
            final List<String> authProperty = headers.get(AUTHORIZATION_PROPERTY);

            // block access if no authorization information is provided
            if (authProperty == null || authProperty.isEmpty()) {
                logger.warn("No token provided!");
                requestContext.abortWith(
                        Response.status(Response.Status.UNAUTHORIZED).entity("You cannot access this resource")
                                .build());
                return;
            }

            String username = null;
            String jwt = authProperty.get(0);

            // try to decode the jwt - deny access if no valid token provided
            TokenGenerator tokenGenerator = new TokenGenerator();
            try {
                username = (String) tokenGenerator.parseJwt(jwt).getBody().get("name");

            } catch (InvalidJwtException e) {
                logger.warn("Invalid token provided!");
                requestContext.abortWith(
                        Response.status(Response.Status.UNAUTHORIZED).entity("You cannot access this resource")
                                .build());
                return;
            }

            // check if token matches an user token (set in user/authenticate)
            UserService userService = new UserServiceImpl();
            User user = null;
            try {
                user = userService.getUserByUsername(username);
            } catch (UserNotFoundException e) {
                logger.warn("Token mismatch!");
                requestContext.abortWith(
                        Response.status(Response.Status.UNAUTHORIZED).entity("You cannot access this resource")
                                .build());
                return;
            }

            //            UserSecurity userSecurity = userDao.getUserAuthentication( user.getId() );
            //
            //            // token does not match with token stored in database - enforce re authentication
            //            if( !userSecurity.getToken().equals( jwt ) ) {
            //                logger.warn("Token expired!");
            //                requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED)
            //                        .entity("You cannot access this resource").build());
            //                return;
            //            }

            // verify user access from provided roles ("ADMIN", "MOHADMIN", "DOC", "PATIENT" ,"STAFF" )
            if (method.isAnnotationPresent(RolesAllowed.class)) {
                // get annotated roles
                RolesAllowed rolesAnnotation = method.getAnnotation(RolesAllowed.class);
                Set<String> rolesSet = new HashSet<String>(Arrays.asList(rolesAnnotation.value()));

                // user valid?
                if (!rolesSet.contains(user.getRole())) {
                    logger.warn("User does not have the rights to access this resource!");
                    requestContext.abortWith(
                            Response.status(Response.Status.UNAUTHORIZED).entity("You cannot access this resource")
                                    .build());
                    return;
                }
            }

            // set header param email for user identification in rest service - do not decode jwt twice in rest services
            //            List<String> idList = new ArrayList<String>();
            //            idList.add( id );
            //            headers.put( HEADER_PROPERTY_ID, idList );
        }
    }

}
