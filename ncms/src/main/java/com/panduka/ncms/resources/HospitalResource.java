package com.panduka.ncms.resources;

import com.panduka.ncms.dto.HospitalDTO;
import com.panduka.ncms.dto.impl.HospitalDTOImpl;
import com.panduka.ncms.services.hospital.HospitalService;
import com.panduka.ncms.services.hospital.HospitalServiceImpl;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;


@Path("/hospitals")
public class HospitalResource {

    HospitalService hospitalService = new HospitalServiceImpl();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<HospitalDTO> getAllHospitals(){

        System.out.println("get all hospitals endpoint");
        List<HospitalDTO> hospitals = hospitalService.getAllHospitals();
        return hospitals;
    }

//    @GET
//    public HospitalDTO getHospitalById(@PathParam("hospital_id") String id){
//        HospitalDTO hospital = hospitalService.getHospitalById(id);
//        return hospital;
//    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createHospital(HospitalDTOImpl newHospitalDTO){
        System.out.println( newHospitalDTO.getChiefDoctorName());

        hospitalService.createHospital(newHospitalDTO);
        return Response.status(Status.CREATED).build();
    }

}
