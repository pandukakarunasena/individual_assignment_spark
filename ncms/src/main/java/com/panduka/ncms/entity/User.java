package com.panduka.ncms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "user")
public class User implements E{

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name = "id", nullable=false, length=50)
    private String id;
    private String username;
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column( name = "last_name")
    private String lastName;

    @OneToOne
    private Hospital hospitalId;

    private String role;

    public User() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Hospital getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Hospital hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override public String toString() {
        return "User{" + "id='" + id + '\'' + ", username='" + username + '\'' + ", password='" + password + '\''
                + ", firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", hospitalId=" + hospitalId
                + ", role='" + role + '\'' + '}';
    }

}
