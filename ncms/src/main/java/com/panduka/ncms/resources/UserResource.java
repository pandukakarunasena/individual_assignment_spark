package com.panduka.ncms.resources;

import com.panduka.ncms.dao.impl.UserDAOImpl;
import com.panduka.ncms.entity.User;
import com.panduka.ncms.exception.InvalidCredentialsException;

import com.panduka.ncms.exception.UserNotFoundException;
import com.panduka.ncms.services.hospital.UserService;
import com.panduka.ncms.services.hospital.UserServiceImpl;
import java.util.List;
import javax.annotation.security.PermitAll;
import javax.ws.rs.FormParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Path("/user") public class UserResource {

    private static final Logger logger = LogManager.getLogger(UserDAOImpl.class);

    //register
    @PermitAll @POST @Path("/register") @Consumes(MediaType.APPLICATION_FORM_URLENCODED) public Response userRegister(
            @FormParam("firstName") String firstName, @FormParam("lastName") String lastName,
            @FormParam("password") String password, @FormParam("role") String role,
            @FormParam("username") String username) {
        if (username.isEmpty() || password.isEmpty() || firstName.isEmpty() || lastName.isEmpty() || role.isEmpty()) {
            return Response.status(400).entity("bad request").build();
        }

        try {
            UserService userService = new UserServiceImpl();
            User newUser = new User(username, password, firstName, lastName, role, null);
            String token = userService.register(newUser);
            Response.ResponseBuilder rb = Response.ok("token sent");
            Response response = rb.header("Authorization", token).build();
            return response;

        } catch (InvalidCredentialsException ex) {
            logger.error(ex.getMessage());
            logger.error(ex.getCause());
            ex.printStackTrace();
            return Response.status(400).entity("").build();
        }
    }

    //login
    @PermitAll @Path("/login") @POST @Consumes(MediaType.APPLICATION_FORM_URLENCODED) @Produces(MediaType.APPLICATION_JSON) public Response userLogin(
            @FormParam("password") String password, @FormParam("username") String username) {
        if (username.isEmpty() || password.isEmpty()) {
            return Response.status(401).entity("bad request").build();
        }
        try {
            UserService userService = new UserServiceImpl();
            List userDetails = userService.login(username, password);

            Response.ResponseBuilder rb = Response.status(200).entity(userDetails.get(1));
            Response response = rb.header("Authorization", userDetails.get(0)).build();
            return response;

        } catch (UserNotFoundException ex) {
            logger.error(ex.getMessage());
            logger.error(ex.getCause());
            ex.printStackTrace();
            return Response.status(401).entity("invalid credentials").build();
        }
    }

}
