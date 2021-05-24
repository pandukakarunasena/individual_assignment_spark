package com.panduka.ncms.controllers;

import com.panduka.ncms.dto.HospitalDTO;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import jakarta.ws.rs.PathParam;
import java.util.List;

@Path("/hospitals")
public class Hospitals {

    HospitalService hospitalService = new HospitalServiceImpl();

    @GET
    public List<HospitalDTO> getAllHospitals(){
        List<HospitalDTO> hospitals = hospitalService.getAllHospitals();
        return hospitals;
    }

    @GET
    public HospitalDTO getHospitalById(@PathParam("hospital_id") String id){
        HospitalDTO hospital = hospitalService.getHospitalById(id);
        return hospital;
    }

}
