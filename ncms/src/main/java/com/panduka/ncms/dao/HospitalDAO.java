package com.panduka.ncms.dao;

import com.panduka.ncms.entity.Hospital;
import com.panduka.ncms.entity.Patient;
import java.util.List;

public interface HospitalDAO {
    Hospital getHospitalById(String id);
    Hospital saveHospital(Hospital newHospital);
    boolean deleteHospital(String id);
    boolean updateHospital(String id, Hospital newHospital);

    List<Hospital> getAllHospitals();
    List<Patient> getPatientsByHospital(String id);

}
