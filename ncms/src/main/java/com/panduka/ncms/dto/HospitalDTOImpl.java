package com.panduka.ncms.dto;

public class HospitalDTOImpl implements HospitalDTO {
    private String name;
    private int noOfBeds;
    private int noOfPatients;
    private float x;
    private float y;
    private String chiefDoctorName;

    public HospitalDTOImpl() { }

    @Override public String getName() {
        return name;
    }

    @Override public void setName(String name) {
        this.name = name;
    }

    @Override public int getNoOfBeds() {
        return noOfBeds;
    }

    @Override public void setNoOfBeds(int noOfBeds) {
        this.noOfBeds = noOfBeds;
    }

    @Override public int getNoOfPatients() {
        return noOfPatients;
    }

    @Override public void setNoOfPatients(int noOfPatients) {
        this.noOfPatients = noOfPatients;
    }

    @Override public float getX() {
        return x;
    }

    @Override public void setX(float x) {
        this.x = x;
    }

    @Override public float getY() {
        return y;
    }

    @Override public void setY(float y) {
        this.y = y;
    }

    @Override public String getChiefDoctorName() {
        return chiefDoctorName;
    }

    @Override public void setChiefDoctorName(String chiefDoctorName) {
        this.chiefDoctorName = chiefDoctorName;
    }

}
