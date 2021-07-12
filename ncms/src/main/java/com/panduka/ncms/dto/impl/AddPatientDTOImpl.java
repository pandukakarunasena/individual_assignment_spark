package com.panduka.ncms.dto.impl;

import com.panduka.ncms.dto.AddPatientDTO;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement public class AddPatientDTOImpl implements AddPatientDTO {
    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private String contact;
    private String email;
    private float x;
    private float y;
    private String district;

    public AddPatientDTOImpl() {
    }

    public AddPatientDTOImpl(String firstName, String lastName, int age, String gender, String contact, String email,
            float x, float y, String district) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAge(age);
        this.setGender(gender);
        this.setContact(contact);
        this.setEmail(email);
        this.setX(x);
        this.setY(y);
        this.setDistrict(district);
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

    @Override public int getAge() {
        return age;
    }

    @Override public void setAge(int age) {
        this.age = age;
    }

    @Override public String getGender() {
        return gender;
    }

    @Override public void setGender(String gender) {
        this.gender = gender;
    }

    @Override public String getContact() {
        return contact;
    }

    @Override public void setContact(String contact) {
        this.contact = contact;
    }

    @Override public String getEmail() {
        return email;
    }

    @Override public void setEmail(String email) {
        this.email = email;
    }

    @Override public float getX() {
        return x;
    }

    @Override public void setX(float x) {
        this.x = x;
    }

    @Override public float getY() {
        return y;
    }

    @Override public void setY(float y) {
        this.y = y;
    }

    @Override public String getDistrict() {
        return district;
    }

    @Override public void setDistrict(String district) {
        this.district = district;
    }

}
