package com.panduka.ncms.dao.impl;

import static org.junit.jupiter.api.Assertions.*;

import com.panduka.ncms.dao.UserDAO;
import com.panduka.ncms.entity.User;
import org.junit.jupiter.api.Test;

class UserDAOImplTest {

    @Test void saveUser() {

        User userToBeAdded = new User("userTest", "password", "jon", "doe", "MOH admin", null);

        UserDAO userDAOImpl = new UserDAOImpl();
        assertEquals(userToBeAdded.getUsername(), userDAOImpl.saveUser(userToBeAdded).getUsername());
    }

    @Test void updateUser() {
        UserDAO userDAOImpl = new UserDAOImpl();
        String id = "402888f27a6d7a01017a6d7a07b30000";
        User existingUser = userDAOImpl.getUser(id);

        existingUser.setUsername("userTest1");
        existingUser.setPassword("password1");

        assertTrue(userDAOImpl.updateUser(id, existingUser));

    }

    @Test void deleteUser() {
        UserDAO userDAOImpl = new UserDAOImpl();
        String id = "402888f27a6d7a01017a6d7a07b30000";
        userDAOImpl.deleteUser(id);
        assertNull(userDAOImpl.getUser(id));
    }

    @Test void getUser() {
        UserDAO userDAOImpl = new UserDAOImpl();
        String id = "402888f27a6d7a01017a6d7a07b30000";
        User existingUser = userDAOImpl.getUser(id);
        assertEquals(id, existingUser.getId());
    }

}