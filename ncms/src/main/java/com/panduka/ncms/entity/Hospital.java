package com.panduka.ncms.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@XmlRootElement @Entity @Table(name = "hospital") public class Hospital {

    @Id @GeneratedValue(generator = "system-uuid") @GenericGenerator(name = "system-uuid", strategy = "uuid") @Column(name = "id", nullable = false, length = 50) private String id;
    private String name;
    private String district;

    @Column(name = "location_x") private float locationX;

    @Column(name = "location_y") private float locationY;

    @Column(name = "build_date") private Date buildDate;

    @Column(name = "avail_beds") private int availBeds;

    @OneToOne private User chiefDoctor;

    @OneToMany(mappedBy = "hospital") @JsonManagedReference @LazyCollection(LazyCollectionOption.FALSE) private List<Patient> patientList;

    @OneToMany(mappedBy = "hospital") @JsonManagedReference @LazyCollection(LazyCollectionOption.FALSE) private List<Bed> bedList;

    public Hospital() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Date getBuildDate() {
        return buildDate;
    }

    public void setBuildDate(Date buildDate) {
        this.buildDate = buildDate;
    }

    public int getAvailBeds() {
        return availBeds;
    }

    public void setAvailBeds(int availBeds) {
        this.availBeds = availBeds;
    }

    public User getChiefDoctor() {
        return chiefDoctor;
    }

    public void setChiefDoctor(User chiefDoctor) {
        this.chiefDoctor = chiefDoctor;
    }

    public List<Patient> getPatientList() {
        return patientList;
    }

    public void setPatientList(List<Patient> patientList) {
        this.patientList = patientList;
    }

    public List<Bed> getBedList() {
        return bedList;
    }

    public void setBedList(List<Bed> bedList) {
        this.bedList = bedList;
    }

    @Override public String toString() {
        return "Hospital{" + "id='" + id + '\'' + ", name='" + name + '\'' + ", district='" + district + '\''
                + ", location_x=" + locationX + ", location_y=" + locationY + ", buildDate=" + buildDate
                + ", availBeds=" + availBeds + '}';
    }

}
