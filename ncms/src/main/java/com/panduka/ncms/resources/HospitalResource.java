package com.panduka.ncms.resources;

import com.panduka.ncms.dto.HospitalDTO;
import com.panduka.ncms.dto.impl.HospitalDTOImpl;
import com.panduka.ncms.entity.Hospital;
import com.panduka.ncms.services.hospital.HospitalService;
import com.panduka.ncms.services.hospital.HospitalServiceImpl;

import java.util.List;

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


@Path("/hospitals")
public class HospitalResource {

    HospitalService hospitalService = new HospitalServiceImpl();

    //endpoint - get hospital by id - api/hospitals/hospital?id="{id}"
    @GET
    @Path("/hospital")
    @Produces(MediaType.APPLICATION_JSON)
    public HospitalDTO getHospitalById(@QueryParam("id") String id){

        HospitalDTO hospital = hospitalService.getHospitalById(id);

        return hospital;
    }

    //endpoint - delete hospital by id - api/hospitals/hospital?id="{id}"
    @DELETE
    @Path("/hospital")
    @Produces( MediaType.APPLICATION_JSON)
    public boolean deleteHospitalById(@QueryParam("id") String id){

        boolean deleted = hospitalService.deleteHospitalById( id);
        return deleted;
    }

    //endpoint - create new hospital - api/hospitals/
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createHospital(HospitalDTOImpl newHospitalDTO){
        System.out.println( newHospitalDTO.getChiefDoctor());
        hospitalService.createHospital(newHospitalDTO);

        return Response.status(Status.CREATED).build();
    }

    //endpoint - get all hospitals - api/hospitals/
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<HospitalDTO> getAllHospitals(){


        List<HospitalDTO> hospitals = hospitalService.getAllHospitals();
        System.out.println( hospitals);

        return hospitals;
    }



}
