package com.panduka.ncms.dao;

import com.panduka.ncms.entity.User;

public interface UserDAO {
    User saveUser(User user);

    boolean deleteUser(String id);

    boolean updateUser(String id, User user);

    User getUser(String id);

}
