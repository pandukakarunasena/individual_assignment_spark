package com.panduka.ncms.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity @Table(name = "patient") public class Patient {

    @Id @GeneratedValue(generator = "system-uuid") @GenericGenerator(name = "system-uuid", strategy = "uuid") @Column(name = "id", nullable = false, length = 50) private String id;

    private String district;

    @Column(name = "first_name") private String firstName;

    @Column(name = "last_name") private String lastName;

    @Column(name = "location_x") private float locationX;

    @Column(name = "location_y") private float locationY;

    @Column(name = "severity_level") private String severityLevel;

    private String gender;
    private String contact;
    private String email;
    private int age;

    @Column(name = "admit_date") private Date admitDate;

    @Column(name = "discharge_date") private Date dischargedDate;

    @OneToOne private Bed bed;

    @OneToOne private User admittedBy;

    @OneToOne private User dischargedBy;

    @ManyToOne @JoinColumn @JsonBackReference private Hospital hospital;

    public Patient() {
    }

    public Patient(String district, String firstName, String lastName, float locationX, float locationY, String gender,
            String contact, String email, int age, Bed bed, Hospital hospital) {
        this.district = district;
        this.firstName = firstName;
        this.lastName = lastName;
        this.locationX = locationX;
        this.locationY = locationY;
        this.gender = gender;
        this.contact = contact;
        this.email = email;
        this.age = age;
        this.bed = bed;
        this.hospital = hospital;
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

    public Bed getBedNo() {
        return bed;
    }

    public void setBedNo(Bed bed) {
        this.bed = bed;
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

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
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

    @Override public String toString() {
        return "Patient{" + "id='" + id + '\'' + ", district='" + district + '\'' + ", firstName='" + firstName + '\''
                + ", lastName='" + lastName + '\'' + ", locationX=" + locationX + ", locationY=" + locationY
                + ", severityLevel='" + severityLevel + '\'' + ", gender='" + gender + '\'' + ", contact='" + contact
                + '\'' + ", email='" + email + '\'' + ", age=" + age + ", admitDate=" + admitDate + ", dischargedDate="
                + dischargedDate + ", bed=" + bed + ", admittedBy=" + admittedBy + ", dischargedBy=" + dischargedBy
                + ", patientQueue=" + ", hospital=" + hospital + '}';
    }

}
