package com.panduka.ncms.dto;

import com.panduka.ncms.entity.Bed;
import java.util.Date;

public interface PatientDTO {
    String getId();

    void setId(String id);

    String getDistrict();

    void setDistrict(String district);

    float getLocationX();

    void setLocationX(float locationX);

    float getLocationY();

    void setLocationY(float locationY);

    String getSeverityLevel();

    void setSeverityLevel(String severityLevel);

    String getGender();

    void setGender(String gender);

    String getContact();

    void setContact(String contact);

    String getEmail();

    void setEmail(String email);

    int getAge();

    void setAge(int age);

    Date getAdmitDate();

    void setAdmitDate(Date admitDate);

    Date getDischargedDate();

    void setDischargedDate(Date dischargedDate);

    Bed getBedNo();

    void setBedNo(Bed bedNo);

    UserDTO getAdmittedBy();

    void setAdmittedBy(UserDTO admittedBy);

    UserDTO getDischargedBy();

    void setDischargedBy(UserDTO dischargedBy);

    HospitalDTO getHospital();

    void setHospital(HospitalDTO hospital);

    void setFirstName(String firstName);

    String getFirstName(String firstName);

    void setLastName(String lastName);

    String getLastName(String lastName);

}
