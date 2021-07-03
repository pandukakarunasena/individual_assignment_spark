package com.panduka.ncms.dao;

import com.panduka.ncms.entity.Patient;
import java.util.List;

public interface PatientDAO {
     Patient getPatientById(String id);
     boolean  savePatient(Patient patient);
     boolean deletePatient(String id);
     boolean updatePatient(String id, Patient newPatientDetails);

     List<Patient> getPatientBySeverity(String severity);
     List<Patient> getAllPatients();
}
