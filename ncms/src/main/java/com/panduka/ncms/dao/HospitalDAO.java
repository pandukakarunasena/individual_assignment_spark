package com.panduka.ncms.dao;

import com.panduka.ncms.entity.Hospital;
import java.util.List;

public interface HospitalDAO {
    //getAllHospital;
    List<Hospital> getAllHospitals();
    Hospital getHospitalById(String id);
    Hospital createHospital(Hospital newHospital);
    boolean deleteHospital(String id);
    boolean updateHospital(String id, Hospital newHospital);


}
