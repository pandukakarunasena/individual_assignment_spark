package com.panduka.ncms.dto;

import com.panduka.ncms.entity.Hospital;
import com.panduka.ncms.entity.PatientQueue;
import com.panduka.ncms.entity.User;
import java.util.Date;

 public interface PatientDTO {
     String getId() ;
     void setId(String id) ;
     String getDistrict() ;
     void setDistrict(String district);
     float getLocationX() ;
     void setLocationX(float locationX) ;
     float getLocationY() ;
     void setLocationY(float locationY);
     String getSeverityLevel();
     void setSeverityLevel(String severityLevel) ;
     String getGender() ;
     void setGender(String gender) ;
     String getContact();
     void setContact(String contact);
     String getEmail();
     void setEmail(String email);
     int getAge() ;
     void setAge(int age) ;
     Date getAdmitDate();
     void setAdmitDate(Date admitDate) ;
     Date getDischargedDate() ;
     void setDischargedDate(Date dischargedDate);
     int getBedNo() ;
     void setBedNo(int bedNo) ;
     User getAdmittedBy();
     void setAdmittedBy(User admittedBy);
     User getDischargedBy();
     void setDischargedBy(User dischargedBy);
     PatientQueue getPatientQueue();
     void setPatientQueue(PatientQueue patientQueue);
     Hospital getHospital();
     void setHospital(Hospital hospital);
}
