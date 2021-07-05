package com.panduka.ncms.services.hospital;

import com.panduka.ncms.entity.User;
import com.panduka.ncms.exception.InvalidCredentialsException;
import javax.persistence.criteria.CriteriaBuilder.In;

public interface UserService {
    String register(User user) throws InvalidCredentialsException;

    String login(String username, String password) throws InvalidCredentialsException;

    boolean update(User user);

    boolean delete(String id);

    User getUserById(String id);

}
