package com.panduka.ncms.resources;

import com.panduka.ncms.dto.AddPatientDTO;
import com.panduka.ncms.dto.PatientDTO;
import com.panduka.ncms.dto.impl.AddPatientDTOImpl;
import com.panduka.ncms.services.hospital.PatientService;
import com.panduka.ncms.services.hospital.PatientServiceImpl;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;


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
    public Response addPatient(
            @FormParam("name") String name,
            @FormParam("age") int age,
            @FormParam("gender") String gender,
            @FormParam("contact") String contact,
            @FormParam("email") String email,
            @FormParam("address") String address)
    {
        AddPatientDTO addPatientDTO = new AddPatientDTOImpl(
                name,
                age,
                gender,
                contact,
                email,
                address
        );

        boolean added = patientService.addPatient( addPatientDTO);

        if( added){
            return Response.status(Status.CREATED).build();
        }

        return Response.status( Status.BAD_REQUEST).build();
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
