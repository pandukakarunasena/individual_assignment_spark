package com.panduka.ncms.resources;

import com.panduka.ncms.dto.PatientDTO;
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

    //localhost:8080/api/patients/patient?={id}
    @GET
    @Path("/patient")
    @Produces(MediaType.APPLICATION_JSON)
    //patient can see the queue number or hospitals can load the patient by id
    public PatientDTO getPatientById(@QueryParam("id") String id){

        return null;
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

    }


    //localhost:8080/api/patients/patient?={id}
    @PUT
    @Path("/patient")
    @Consumes( MediaType.APPLICATION_JSON)
    public void updatePatient(@QueryParam("id") String id){

    }

    //localhost:8080/api/patients?={severity}
    @GET
    public List<PatientDTO> getPatientBySeverity(){
        return null;
    }

    //localhost:8080/api/patients/
    @GET
    @Produces( MediaType.APPLICATION_JSON)
    public List<PatientDTO> getAllPatients(){
        return null;
    }


}
