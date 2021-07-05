package com.panduka.ncms.services.hospital;

import com.panduka.ncms.auth.TokenGenerator;
import com.panduka.ncms.dao.UserDAO;
import com.panduka.ncms.dao.impl.UserDAOImpl;
import com.panduka.ncms.entity.User;
import com.panduka.ncms.exception.InvalidCredentialsException;

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

    @Override public String login(String username, String password) throws InvalidCredentialsException {

        UserDAO userDAO = new UserDAOImpl();
        User user = userDAO.getUserByUserNameAndPassword(username, password);

        if (user == null) {
            throw new InvalidCredentialsException();
        }

        String token = new TokenGenerator().generateToken(username, password);
        return token;
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
