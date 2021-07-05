package com.panduka.ncms.services.hospital;

import com.panduka.ncms.entity.User;
import com.panduka.ncms.exception.InvalidCredentialsException;
import com.panduka.ncms.exception.UserNotFoundException;
import javax.persistence.criteria.CriteriaBuilder.In;

public interface UserService {
    String register(User user) throws InvalidCredentialsException;

    String login(String username, String password) throws UserNotFoundException;

    User getUserByUsername( String username) throws UserNotFoundException;

    boolean update(User user);

    boolean delete(String id);

    User getUserById(String id);

}
