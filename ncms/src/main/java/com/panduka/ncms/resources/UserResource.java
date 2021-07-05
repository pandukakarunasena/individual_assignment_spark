package com.panduka.ncms.resources;

import com.panduka.ncms.auth.TokenGenerator;
import com.panduka.ncms.dao.impl.UserDAOImpl;
import com.panduka.ncms.entity.User;
import com.panduka.ncms.exception.InvalidCredentialsException;
import javax.persistence.UniqueConstraint;
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
    @POST @Path("/register") @Consumes(MediaType.APPLICATION_JSON) @Produces(MediaType.APPLICATION_JSON) public void userSignIn(
            @FormParam("firstName") String firstName, @FormParam("lastName") String lastName,
            @FormParam("password") String password, @FormParam("role") String role,
            @FormParam("username") String username) {
        //1. check for exiting users in database by the username
        //if yes UserCreationFailed exception else
        //create a user and send a JWT to login
    }

    //login
    @Path("/login") @POST @Consumes(MediaType.APPLICATION_FORM_URLENCODED) public Response userLogin(
            @FormParam("password") String password, @FormParam("username") String username) {
        if (username.isEmpty() || password.isEmpty()) {
            return Response.status(401).entity("bad request").build();
        }
        try {
            User user = new UserDAOImpl().getUserByUserNameAndPassword(username, password);

            if (user == null) {
                throw new InvalidCredentialsException();
            }

            String token = new TokenGenerator().generateToken(username, password);
            return Response.status(200).entity(token).build();

        } catch (InvalidCredentialsException ex) {
            logger.error(ex.getMessage());
            logger.error(ex.getCause());
            ex.printStackTrace();
            return Response.status(403).entity("unauthorized").build();
        }
    }

}
