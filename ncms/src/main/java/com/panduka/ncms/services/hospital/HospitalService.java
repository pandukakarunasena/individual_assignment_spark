package com.panduka.ncms.services.hospital;

import com.panduka.ncms.dto.PatientDTO;
import com.panduka.ncms.entity.Hospital;
import java.util.List;

public interface HospitalService {
    List<Hospital> getAllHospitals();

    Hospital getHospitalById(String id);

    Hospital createHospital(Hospital newHospital);

    boolean deleteHospitalById(String id);

    List<PatientDTO> getPatientsByHospital(String id);

}

