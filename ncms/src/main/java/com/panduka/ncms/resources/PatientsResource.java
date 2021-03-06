package com.panduka.ncms.resources;

import com.panduka.ncms.dto.AddPatientDTO;
import com.panduka.ncms.dto.PatientDTO;
import com.panduka.ncms.dto.impl.AddPatientDTOImpl;
import com.panduka.ncms.dto.impl.PatientClient;
import com.panduka.ncms.services.hospital.PatientService;
import com.panduka.ncms.services.hospital.PatientServiceImpl;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
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

@Path("/patients") public class PatientsResource {

    PatientService patientService = new PatientServiceImpl();

    //localhost:8080/api/patients/patient?={id}
    @GET @Path("/patient") @Produces(MediaType.APPLICATION_JSON) @PermitAll
    //patient can see the queue number or hospitals can load the patient by id
    public PatientClient getPatientById(@QueryParam("id") String id) {
        PatientClient patientToClient = patientService.getPatientById(id);
        if (patientToClient == null) {
            return null;
        }

        return patientToClient;
    }

    //localhost:8080/api/patients/patient/
    @POST @Path("/patient") @PermitAll @Produces(MediaType.APPLICATION_JSON) public Response addPatient(
            @FormParam("firstName") String firstName, @FormParam("lastName") String lastName, @FormParam("age") int age,
            @FormParam("gender") String gender, @FormParam("phone") String contact, @FormParam("email") String email,
            @FormParam("locationX") float x, @FormParam("locationY") float y, @FormParam("district") String district) {
        AddPatientDTO addPatientDTO = new AddPatientDTOImpl(firstName, lastName, age, gender, contact, email, x, y,
                district);

        String createdPatientSerialNumber = patientService.addPatient(addPatientDTO);
        System.out.println(createdPatientSerialNumber);
        if (createdPatientSerialNumber != null) {
            return Response.status(Status.CREATED).entity(createdPatientSerialNumber).build();
        }

        return Response.status(Status.BAD_REQUEST).build();
    }

    //localhost:8080/api/patients/patient?={id}
    @DELETE @Path("/patient") @RolesAllowed({ "MOHADMIN", "DOCTOR", "CHIEFDOCTOR" }) public void deletePatient(
            @QueryParam("id") String id) {
        boolean deleted = patientService.deletePatient(id);

        if (deleted) {
            //return deleted msg with id
        } else {
            //error message
        }
    }

    //localhost:8080/api/patients/patient?={id}
    @PUT @Path("/patient") @Consumes(MediaType.APPLICATION_JSON) @RolesAllowed({ "MOHADMIN", "DOCTOR",
            "CHIEFDOCTOR" }) public void updatePatient(@QueryParam("id") String id) {

    }

    //localhost:8080/api/patients?={severity}
    @GET @RolesAllowed({ "MOHADMIN", "DOCTOR", "CHIEFDOCTOR" }) public List<PatientDTO> getPatientBySeverity(
            @QueryParam("severity") String severity) {
        List<PatientDTO> patientDTOListBySeverity = patientService.getPatientBySeverity(severity);

        return patientDTOListBySeverity;
    }

    //localhost:8080/api/patients/
    @GET @Produces(MediaType.APPLICATION_JSON) @RolesAllowed("MOHADMIN") public List<PatientDTO> getAllPatients() {
        List<PatientDTO> patientDTOList = patientService.getAllPatients();
        System.out.println(patientDTOList);
        return patientDTOList;
    }

}
