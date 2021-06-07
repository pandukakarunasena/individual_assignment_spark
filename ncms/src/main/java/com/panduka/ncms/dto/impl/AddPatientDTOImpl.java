package com.panduka.ncms.dto.impl;

import com.panduka.ncms.dto.AddPatientDTO;

public class AddPatientDTOImpl implements AddPatientDTO {
    String name;
    int age;
    String gender;
    String contact;
    String email;
    String address;

    public AddPatientDTOImpl() {
    }

    public AddPatientDTOImpl(String name, int age, String gender, String contact, String email, String address) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.contact = contact;
        this.email = email;
        this.address = address;
    }

    @Override public String getName() {
        return name;
    }

    @Override public int getAge() {
        return age;
    }

    @Override public String getGender() {
        return gender;
    }

    @Override public String getContact() {
        return contact;
    }

    @Override public String getEmail() {
        return email;
    }

    @Override public String getAddress() {
        return address;
    }

}
