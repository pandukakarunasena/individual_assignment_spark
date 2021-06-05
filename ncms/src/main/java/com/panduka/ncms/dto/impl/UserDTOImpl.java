package com.panduka.ncms.dto.impl;


import com.panduka.ncms.dto.UserDTO;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserDTOImpl implements UserDTO, Serializable {
    private String id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private HospitalDTOImpl hospitalId;
    private String role;

    public UserDTOImpl() { }

    public UserDTOImpl(String username, String password, String firstName, String lastName, HospitalDTOImpl hospitalId,
            String role) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }

    @Override public String getUsername() {
        return username;
    }

    @Override public void setUsername(String username) {
        this.username = username;
    }

    @Override public String getPassword() {
        return password;
    }

    @Override public void setPassword(String password) {
        this.password = password;
    }

    @Override public String getFirstName() {
        return firstName;
    }

    @Override public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override public String getLastName() {
        return lastName;
    }

    @Override public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override public String getRole() {
        return role;
    }

    @Override public void setRole(String role) {
        this.role = role;
    }

    @Override public void setId(String id) {
        this.id = id;
    }

    @Override public String getId() {
        return this.id;
    }

}
