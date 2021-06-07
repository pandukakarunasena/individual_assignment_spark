package com.panduka.ncms.services.hospital;

import com.panduka.ncms.dto.AddPatientDTO;
import com.panduka.ncms.dto.PatientDTO;
import java.util.List;

public interface PatientService {
    PatientDTO getPatientById( String id);
    boolean addPatient( AddPatientDTO patient);
    boolean deletePatient( String id);
    boolean updatePatient( String id, PatientDTO newPatientDetails);
    List<PatientDTO> getPatientBySeverity( String severity);
    List<PatientDTO> getAllPatients();
}
