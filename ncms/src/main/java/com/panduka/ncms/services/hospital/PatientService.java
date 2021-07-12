package com.panduka.ncms.services.hospital;

import com.panduka.ncms.dto.AddPatientDTO;
import com.panduka.ncms.dto.PatientDTO;
import com.panduka.ncms.dto.impl.PatientClient;
import java.util.List;

public interface PatientService {
    PatientClient getPatientById(String id);

    String addPatient(AddPatientDTO patient);

    boolean deletePatient(String id);

    boolean updatePatient(String id, PatientDTO newPatientDetails);

    List<PatientDTO> getPatientBySeverity(String severity);

    List<PatientDTO> getAllPatients();

}
