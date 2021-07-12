package com.panduka.ncms.resources;

import com.panduka.ncms.dto.PatientDTO;
import com.panduka.ncms.entity.Hospital;
import com.panduka.ncms.services.hospital.HospitalService;
import com.panduka.ncms.services.hospital.HospitalServiceImpl;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Path("/hospitals") public class HospitalResource {

    HospitalService hospitalService = new HospitalServiceImpl();
    Logger logger = LogManager.getLogger(HospitalResource.class);

    //endpoint - get hospital by id - api/hospitals/hospital?id="{id}"
    @GET @Path("/hospital") @Produces(MediaType.APPLICATION_JSON) @RolesAllowed({ "MOHADMIN", "DOCTOR",
            "CHIEFDOCTOR" }) public Hospital getHospitalById(@QueryParam("id") String id) {
        Hospital hospital = hospitalService.getHospitalById(id);
        return hospital;
    }

    //endpoint - delete hospital by id - api/hospitals/hospital?id="{id}"
    @DELETE @Path("/hospital") @Produces(MediaType.APPLICATION_JSON) @RolesAllowed("MOHADMIN") public boolean deleteHospitalById(
            @QueryParam("id") String id) {
        boolean deleted = hospitalService.deleteHospitalById(id);
        return deleted;
    }

    //endpoint - create new hospital - api/hospitals/
    @POST @Consumes(MediaType.APPLICATION_JSON) @Produces(MediaType.APPLICATION_JSON) @RolesAllowed("MOHADMIN") public Response createHospital(
            Hospital newHospital) {
        //take the form data and convert send to service
        hospitalService.createHospital(newHospital);
        return Response.status(Status.CREATED).build();
    }

    //endpoint - get all hospitals - api/hospitals/
    @GET @Produces(MediaType.APPLICATION_JSON) @RolesAllowed("MOHADMIN") public List<Hospital> getAllHospitals() {
        List<Hospital> hospitals = hospitalService.getAllHospitals();
        return hospitals;
    }

    @GET @Path("/patients") @Produces(MediaType.APPLICATION_JSON) @RolesAllowed({ "MOHADMIN", "DOCTOR",
            "CHIEFDOCTOR" }) public List<PatientDTO> getPatientByHospital(@QueryParam("id") String id) {
        List<PatientDTO> patientDTOList = hospitalService.getPatientsByHospital(id);
        return patientDTOList;
    }

}
