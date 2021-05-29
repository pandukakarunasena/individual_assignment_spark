package com.panduka.ncms.services.hospital;

import com.panduka.ncms.dto.HospitalDTO;

import java.util.List;

public interface HospitalService {
    List<HospitalDTO> getAllHospitals();
    HospitalDTO getHospitalById(String id);
    HospitalDTO createHospital( HospitalDTO newHospital);
}

