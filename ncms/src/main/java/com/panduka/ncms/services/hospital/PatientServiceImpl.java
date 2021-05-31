package com.panduka.ncms.services.hospital;

import com.panduka.ncms.dao.PatientDAO;
import com.panduka.ncms.dao.impl.PatientDAOImpl;
import com.panduka.ncms.dto.PatientDTO;
import java.util.List;

public class PatientServiceImpl implements PatientService{

    PatientDAO patientManager = new PatientDAOImpl();

    @Override public PatientDTO getPatientById(String id) {
        return null;
    }

    @Override public void addPatient(PatientDTO patient) {

    }

    @Override public boolean deletePatient(String id) {
        return false;
    }

    @Override public boolean updatePatient(String id, PatientDTO newPatientDetails) {
        return false;
    }

    @Override public List<PatientDTO> getPatientBySeverity(String severity) {
        return null;
    }

    @Override public List<PatientDTO> getAllPatients() {
        return null;
    }

}
