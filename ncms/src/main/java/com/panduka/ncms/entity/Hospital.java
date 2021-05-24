package com.panduka.ncms.entity;

import java.sql.Date;

public class Hospital {
    private String id;
    private String name;
    private String district;
    private float locationX;
    private float locationY;
    private Date build_date;
    private int avail_beds;

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

    public float getLocation_x() {
        return locationX;
    }

    public void setLocation_x(float locationX) {
        this.locationX = locationX;
    }

    public float getLocation_y() {
        return locationY;
    }

    public void setLocation_y(float location_y) {
        this.locationY = locationY;
    }

    public Date getBuild_date() {
        return build_date;
    }

    public void setBuild_date(Date build_date) {
        this.build_date = build_date;
    }

    public int getAvail_beds() {
        return avail_beds;
    }

    public void setAvail_beds(int avail_beds) {
        this.avail_beds = avail_beds;
    }

    @Override public String toString() {
        return "Hospital{" + "id='" + id + '\'' + ", name='" + name + '\'' + ", district='" + district + '\''
                + ", location_x=" + locationX + ", location_y=" + locationY + ", build_date=" + build_date
                + ", avail_beds=" + avail_beds + '}';
    }

}
