package com.panduka.ncms.dto;

import com.panduka.ncms.dto.impl.UserDTOImpl;

public interface HospitalDTO {
    String getName();

    void setName(String name);

    int getNoOfBeds();

    void setNoOfBeds(int noOfBeds);

    int getNoOfPatients();

    void setNoOfPatients(int noOfPatients);

    float getX();

    void setX(float x);

    float getY();

    void setY(float y);

    UserDTOImpl getChiefDoctorName();

    void setChiefDoctorName(UserDTOImpl chiefDoctorName);

    String getDistrictName();

    void setDistrictName(String districtName);

}
