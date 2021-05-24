package com.panduka.ncms.controllers;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/patients")
public class Patients {

    //localhost:8080/api/patients/{id}
    @GET
    @Path("{id}")
    public PatientDTO getPatientById(@PathParam("id") String id){

    }

    //localhost:8080/api/patients/add
    @POST
    @Path("/add")
    public void addPatient(){

    }

    //localhost:8080/api/patients/{id}
    @DELETE
    @Path("{id}")
    public void deletePatient(){}


    //localhost:8080/api/patients/{id}
    @PUT
    @Path()
    public void updatePatient(){

    }

    //localhost:8080/api/patients/{hospital_id}
    @GET
    public List<PatientDTO> getPatientByHospital(){

    }

    //localhost:8080/api/patients/{severity}
    @GET
    public List<PatientDTO> getPatientBySeverity(){

    }

    //localhost:8080/api/patients/
    @GET
    public List<PatientDTO> getAllPatients(){

    }


}
