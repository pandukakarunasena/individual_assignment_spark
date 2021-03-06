package com.panduka.ncms.services.hospital;

import com.panduka.ncms.auth.TokenGenerator;
import com.panduka.ncms.dao.UserDAO;
import com.panduka.ncms.dao.impl.UserDAOImpl;
import com.panduka.ncms.dto.impl.UserClient;
import com.panduka.ncms.entity.User;
import com.panduka.ncms.exception.InvalidCredentialsException;
import com.panduka.ncms.exception.UserNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {

    @Override public String register(User user) throws InvalidCredentialsException {

        UserDAO userDAO = new UserDAOImpl();
        User existingUserByTheUsername = userDAO.getUserByUsername(user.getUsername());

        if (existingUserByTheUsername != null) {
            throw new InvalidCredentialsException();
        }

        userDAO.saveUser(user);

        String token = new TokenGenerator().generateToken(user.getUsername(), user.getPassword());
        return token;
    }

    @Override public List<Object> login(String username, String password) throws UserNotFoundException {

        UserDAO userDAO = new UserDAOImpl();
        User user = userDAO.getUserByUserNameAndPassword(username, password);

        if (user == null) {
            throw new UserNotFoundException();
        }

        UserClient userClient = new UserClient(user.getId(), user.getUsername(), user.getFirstName(),
                user.getLastName(), null, user.getRole());

        String token = new TokenGenerator().generateToken(username, password);

        userClient.setToken(token);

        List userDetails = new ArrayList();
        userDetails.add(token);
        userDetails.add(userClient);

        return userDetails;
    }

    @Override public User getUserByUsername(String username) throws UserNotFoundException {
        UserDAO userDAO = new UserDAOImpl();
        User user = userDAO.getUserByUsername(username);

        if (user == null) {
            throw new UserNotFoundException();
        }
        return user;
    }

    @Override public boolean update(User user) {
        return false;
    }

    @Override public boolean delete(String id) {
        return false;
    }

    @Override public User getUserById(String id) {
        return null;
    }

}
