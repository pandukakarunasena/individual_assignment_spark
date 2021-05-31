package com.panduka.ncms.dto;

import java.util.List;

public interface HospitalDTO {
    String getId();

    void setId( String id);

    String getName();

    void setName(String name);

    int getNoOfBeds();

    void setNoOfBeds(int noOfBeds);

    List<PatientDTO> getPatients();

    void setPatients(List<PatientDTO> noOfPatients);

    float getX();

    void setX(float x);

    float getY();

    void setY(float y);

    UserDTO getChiefDoctor();

    void setChiefDoctor(UserDTO chiefDoctor);

    String getDistrictName();

    void setDistrictName(String districtName);

    void addPatient( PatientDTO patient);
}
