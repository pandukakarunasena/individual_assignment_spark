package com.panduka.ncms.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hospital")
public class Hospital implements E{

    @Id
    //@GeneratedValue(strategy= GenerationType.IDENTITY)
    private String id;
    private String name;
    private String district;

    @Column(name="location_x")
    private float locationX;

    @Column(name="location_y")
    private float locationY;

    @Column(name="build_date")
    private Date buildDate;

    @Column(name="avail_beds")
    private int availBeds;

    //private User chiefDoctor;

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

    public void setLocationY(float location_y) {
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

//    public User getChiefDoctor() {
//        return chiefDoctor;
//    }
//
//    public void setChiefDoctor(User chiefDoctor) {
//        this.chiefDoctor = chiefDoctor;
//    }
    @Override public String toString() {
        return "Hospital{" + "id='" + id + '\'' + ", name='" + name + '\'' + ", district='" + district + '\''
                + ", location_x=" + locationX + ", location_y=" + locationY + ", buildDate=" + buildDate
                + ", availBeds=" + availBeds + '}';
    }



}
