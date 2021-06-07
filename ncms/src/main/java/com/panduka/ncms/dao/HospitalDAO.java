package com.panduka.ncms.dao;

import com.panduka.ncms.entity.Hospital;
import com.panduka.ncms.entity.Patient;
import java.util.List;

public interface HospitalDAO {

    List<Hospital> getAllHospitals();
    Hospital getHospitalById(String id);
    Hospital createHospital(Hospital newHospital);
    boolean deleteHospital(String id);
    boolean updateHospital(String id, Hospital newHospital);

    List<Patient> getPatientsByHospital(String id);

}
