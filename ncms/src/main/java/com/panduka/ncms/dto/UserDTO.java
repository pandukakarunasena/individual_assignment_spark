package com.panduka.ncms.dto;

import com.panduka.ncms.dto.impl.HospitalDTOImpl;

public interface UserDTO {
    String getUsername();

    void setUsername(String username);

    String getPassword();

    void setPassword(String password);

    String getFirstName();

    void setFirstName(String firstName);

    String getLastName();

    void setLastName(String lastName);

    HospitalDTOImpl getHospitalId();

    void setHospitalId(HospitalDTOImpl hospitalId);

    String getRole();

    void setRole(String role);

}
