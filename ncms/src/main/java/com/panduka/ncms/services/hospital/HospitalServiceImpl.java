package com.panduka.ncms.services.hospital;

import com.panduka.ncms.dao.HospitalDAO;
import com.panduka.ncms.dao.HospitalDAOImpl;
import com.panduka.ncms.dto.HospitalDTO;

import com.panduka.ncms.dto.impl.HospitalDTOImpl;
import com.panduka.ncms.entity.Hospital;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HospitalServiceImpl implements HospitalService{

    HospitalDAO hospitalManager = new HospitalDAOImpl();

    @Override
    public List<HospitalDTO> getAllHospitals() {
        List<Hospital> hospitals = hospitalManager.getAllHospitals();
        List<HospitalDTO> hospitalsConverted = new ArrayList<>();

        for( Hospital hos: hospitals){
            HospitalDTO newHos = new HospitalDTOImpl();
            newHos.setName( hos.getName());
            hospitalsConverted.add( newHos);

        }
        return hospitalsConverted;
    }

    @Override
    public HospitalDTO getHospitalById(String id) {
        return null;
    }

    @Override public HospitalDTO createHospital(HospitalDTO newHospitalDTO) {



        //convert hospitalDTO to hospital entity
        // use a mapper to map DTO to entities
        //Hospital newHospital = new HospitalDTOImpl();

        Hospital newHospitalEntity = new Hospital();
        newHospitalEntity.setId("testhospital112344");
        newHospitalEntity.setName( newHospitalDTO.getName() );
        newHospitalEntity.setDistrict( newHospitalDTO.getDistrictName() );
        newHospitalEntity.setLocationX( newHospitalDTO.getX() );
        newHospitalEntity.setLocationY( newHospitalDTO.getY() );
        newHospitalEntity.setBuildDate( new Date());
        newHospitalEntity.setAvailBeds( 10 );
        //newHospitalEntity.setChiefDoctor( newHospitalDTO.getChiefDoctorName() );

        Hospital createdHospital = hospitalManager.createHospital(newHospitalEntity);

        //convert the returned entity object to DTO before returning
        System.out.println( createdHospital);

        return newHospitalDTO;
    }

}
