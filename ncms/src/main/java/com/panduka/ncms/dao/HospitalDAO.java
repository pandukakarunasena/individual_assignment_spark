package com.panduka.ncms.dao;

import com.panduka.ncms.dto.HospitalDTO;
import com.panduka.ncms.entity.Hospital;
import java.util.List;

public interface HospitalDAO {
    //getAllHospital;
    List<Hospital> getAllHospitals();

    //getHospitalById;
    Hospital getHospitalById(String id);

    //create a hospital
    Hospital createHospital(Hospital newHospital);

    //delete a hospital
    boolean deleteHospital();

    //update a hospital
    boolean updateHospital();


}
