package com.panduka.ncms.resources;

import com.panduka.ncms.dto.PatientDTO;
import com.panduka.ncms.services.hospital.PatientService;
import com.panduka.ncms.services.hospital.PatientServiceImpl;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/patients")
public class PatientsResource {

    PatientService patientService = new PatientServiceImpl();

    //localhost:8080/api/patients/patient?={id}
    @GET
    @Path("/patient")
    @Produces(MediaType.APPLICATION_JSON)
    //patient can see the queue number or hospitals can load the patient by id
    public PatientDTO getPatientById(@QueryParam("id") String id){

        PatientDTO patientDTO = patientService.getPatientById( id);
        if( patientDTO == null){
            //send error message
        }

        return patientDTO;
    }

    //localhost:8080/api/patients/patient/
    @POST
    @Path("/patient")
    @Consumes( MediaType.APPLICATION_JSON)
    public void addPatient(){

    }

    //localhost:8080/api/patients/patient?={id}
    @DELETE
    @Path("/patient")
    public void deletePatient(@QueryParam("id") String id){
        boolean deleted = patientService.deletePatient( id);

        if( deleted){
            //return deleted msg with id
        }else{
            //error message
        }
    }


    //localhost:8080/api/patients/patient?={id}
    @PUT
    @Path("/patient")
    @Consumes( MediaType.APPLICATION_JSON)
    public void updatePatient(@QueryParam("id") String id){

    }

    //localhost:8080/api/patients?={severity}
    @GET
    public List<PatientDTO> getPatientBySeverity(@QueryParam("severity") String severity){
        List<PatientDTO> patientDTOListBySeverity = patientService.getPatientBySeverity(severity );

        return patientDTOListBySeverity;
    }

    //localhost:8080/api/patients/
    @GET
    @Produces( MediaType.APPLICATION_JSON)
    public List<PatientDTO> getAllPatients(){
        List<PatientDTO> patientDTOList = patientService.getAllPatients();
        System.out.println( patientDTOList);
        return patientDTOList;
    }


}
