package com.panduka.ncms.dto.impl;

import com.panduka.ncms.dto.PatientDTO;
import com.panduka.ncms.entity.Hospital;
import com.panduka.ncms.entity.PatientQueue;
import com.panduka.ncms.entity.User;
import java.io.Serializable;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PatientDTOImpl implements PatientDTO, Serializable{
    private String id;
    private String district;
    private float locationX;
    private float locationY;
    private String severityLevel;
    private String gender;
    private String contact;
    private String email;
    private int age;
    private Date admitDate;
    private Date dischargedDate;
    private int bedNo;
    private User admittedBy;
    private User dischargedBy;
    private PatientQueue patientQueue;
    private Hospital hospital;

    public PatientDTOImpl() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public float getLocationX() {
        return locationX;
    }

    public void setLocationX(float locationX) {
        this.locationX = locationX;
    }

    public float getLocationY() {
        return locationY;
    }

    public void setLocationY(float locationY) {
        this.locationY = locationY;
    }

    public String getSeverityLevel() {
        return severityLevel;
    }

    public void setSeverityLevel(String severityLevel) {
        this.severityLevel = severityLevel;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getAdmitDate() {
        return admitDate;
    }

    public void setAdmitDate(Date admitDate) {
        this.admitDate = admitDate;
    }

    public Date getDischargedDate() {
        return dischargedDate;
    }

    public void setDischargedDate(Date dischargedDate) {
        this.dischargedDate = dischargedDate;
    }

    public int getBedNo() {
        return bedNo;
    }

    public void setBedNo(int bedNo) {
        this.bedNo = bedNo;
    }

    public User getAdmittedBy() {
        return admittedBy;
    }

    public void setAdmittedBy(User admittedBy) {
        this.admittedBy = admittedBy;
    }

    public User getDischargedBy() {
        return dischargedBy;
    }

    public void setDischargedBy(User dischargedBy) {
        this.dischargedBy = dischargedBy;
    }

    public PatientQueue getPatientQueue() {
        return patientQueue;
    }

    public void setPatientQueue(PatientQueue patientQueue) {
        this.patientQueue = patientQueue;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    @Override public String toString() {
        return "PatientDTOImpl{" + "id='" + id + '\'' + ", district='" + district + '\'' + ", locationX=" + locationX
                + ", locationY=" + locationY + ", severityLevel='" + severityLevel + '\'' + ", gender='" + gender + '\''
                + ", contact='" + contact + '\'' + ", email='" + email + '\'' + ", age=" + age + ", admitDate="
                + admitDate + ", dischargedDate=" + dischargedDate + ", bedNo=" + bedNo + ", admittedBy=" + admittedBy
                + ", dischargedBy=" + dischargedBy + ", patientQueue=" + patientQueue + ", hospital=" + hospital + '}';
    }

}
