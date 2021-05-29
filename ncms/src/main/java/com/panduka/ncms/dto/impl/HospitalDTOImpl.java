package com.panduka.ncms.dto.impl;

import com.panduka.ncms.dto.DTO;
import com.panduka.ncms.dto.HospitalDTO;
import com.panduka.ncms.dto.impl.UserDTOImpl;
import com.panduka.ncms.entity.User;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class HospitalDTOImpl implements HospitalDTO, Serializable, DTO {
    private String name;
    private int noOfBeds;
    private int noOfPatients;
    private float x;
    private float y;
    private UserDTOImpl chiefDoctorName;
    private String districtName;

    public HospitalDTOImpl() { }

    public HospitalDTOImpl(String name, int noOfBeds, int noOfPatients, float x, float y, UserDTOImpl chiefDoctorName,
            String districtName) {
        this.name = name;
        this.noOfBeds = noOfBeds;
        this.noOfPatients = noOfPatients;
        this.x = x;
        this.y = y;
        this.chiefDoctorName = chiefDoctorName;
        this.districtName = districtName;
    }

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

    @Override public UserDTOImpl getChiefDoctorName() {
        return chiefDoctorName;
    }

    @Override public void setChiefDoctorName(UserDTOImpl chiefDoctorName) {
        this.chiefDoctorName = chiefDoctorName;
    }

    @Override public String getDistrictName() {
        return null;
    }

    @Override public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

}
