package com.panduka.ncms.services.hospital;

import com.panduka.ncms.dao.HospitalDAO;
import com.panduka.ncms.dao.impl.HospitalDAOImpl;
import com.panduka.ncms.dto.PatientDTO;
import com.panduka.ncms.entity.Hospital;
import com.panduka.ncms.entity.Patient;
import com.panduka.ncms.helpers.Mapper;
import java.util.ArrayList;
import java.util.List;

public class HospitalServiceImpl implements HospitalService {

    HospitalDAO hospitalManager = new HospitalDAOImpl();

    @Override public List<Hospital> getAllHospitals() {
        System.out.println("get all hospitals service");
        List<Hospital> hospitals = hospitalManager.getAllHospitals();

        //no need to convert the object
        return hospitals;
    }

    @Override public Hospital getHospitalById(String id) {
        Hospital hospital = hospitalManager.getHospitalById(id);
        return hospital;
    }

    @Override public Hospital createHospital(Hospital newHospital) {
        Hospital newHospitalEntity = newHospital;
        hospitalManager.saveHospital(newHospitalEntity);
        return newHospital;
    }

    @Override public boolean deleteHospitalById(String id) {
        boolean deleted = hospitalManager.deleteHospital(id);
        return deleted;
    }

    @Override public List<PatientDTO> getPatientsByHospital(String id) {
        List<Patient> patientListByHospital = hospitalManager.getPatientsByHospital(id);

        List<PatientDTO> patientDTOListByHospital = new ArrayList<>();

        for (Patient p : patientListByHospital) {
            PatientDTO patientDTO = (PatientDTO) Mapper.convertToDTO(p);
            patientDTOListByHospital.add(patientDTO);
        }

        return patientDTOListByHospital;
    }

}
