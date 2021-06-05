package com.panduka.ncms.dto.impl;

import com.panduka.ncms.dto.HospitalDTO;
import com.panduka.ncms.dto.PatientDTO;
import com.panduka.ncms.dto.UserDTO;
import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class HospitalDTOImpl implements HospitalDTO, Serializable {
    private String id;
    private String name;
    private int noOfBeds;
    private List<PatientDTO> patientsList;
    private float x;
    private float y;
    private UserDTO chiefDoctor;
    private String districtName;

    public HospitalDTOImpl() { }

    public HospitalDTOImpl(String name, int noOfBeds, List<PatientDTO> patientsList, float x, float y, UserDTO chiefDoctor,
            String districtName) {
        this.name = name;
        this.noOfBeds = noOfBeds;
        this.patientsList = patientsList;
        this.x = x;
        this.y = y;
        this.chiefDoctor = chiefDoctor;
        this.districtName = districtName;
    }

    @Override public String getId() { return id; }

    @Override public void setId(String id) {
        this.id = id;
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

    @Override public List<PatientDTO> getPatients() {
        return patientsList;
    }

    @Override public void setPatients(List<PatientDTO> patientsList) {
        this.patientsList = patientsList;
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

    @Override public UserDTO getChiefDoctor() {
        return chiefDoctor;
    }

    @Override public void setChiefDoctor(UserDTO chiefDoctor) {
        this.chiefDoctor = chiefDoctor;
    }

    @Override public String getDistrictName() {
        return districtName;
    }

    @Override public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }


    @Override public void addPatient(PatientDTO patient) {
        patientsList.add(patient);
    }

}
