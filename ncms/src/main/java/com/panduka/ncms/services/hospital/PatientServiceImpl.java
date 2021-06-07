package com.panduka.ncms.services.hospital;

import com.panduka.ncms.dao.PatientDAO;
import com.panduka.ncms.dao.impl.PatientDAOImpl;
import com.panduka.ncms.dto.AddPatientDTO;
import com.panduka.ncms.dto.PatientDTO;
import com.panduka.ncms.entity.Patient;
import com.panduka.ncms.helpers.Mapper;
import java.util.ArrayList;
import java.util.List;

public class PatientServiceImpl implements PatientService{

    PatientDAO patientManager = new PatientDAOImpl();

    @Override public PatientDTO getPatientById(String id) {
        Patient patient = patientManager.getPatientById( id);
        System.out.println( "patient service getPatientById method"+ patient);
        if( patient == null){
            return null;
        }

        PatientDTO patientDTO = (PatientDTO) Mapper.convertToDTO( patient);
        return patientDTO;
    }

    @Override public boolean deletePatient(String id) {
        boolean deleted = patientManager.deletePatient( id);
        return deleted;
    }

    @Override public List<PatientDTO> getPatientBySeverity(String severity) {
        List<Patient> patientListBySeverity = patientManager.getPatientBySeverity( severity);
        List<PatientDTO> patientDTOListBySeverity = new ArrayList<>();
        for ( Patient p : patientListBySeverity){
            PatientDTO patientDTO = (PatientDTO) Mapper.convertToDTO( p);
            patientDTOListBySeverity.add( patientDTO);
        }

        return patientDTOListBySeverity;
    }

    @Override public List<PatientDTO> getAllPatients() {
        List<Patient> patientList = patientManager.getAllPatients();
        System.out.println( "patient service get all method"+ patientList);

        List<PatientDTO> patientDTOList = new ArrayList<>();
        for ( Patient p : patientList){
            PatientDTO patientDTO = (PatientDTO) Mapper.convertToDTO( p);
            patientDTOList.add( patientDTO);
        }

        return patientDTOList;

    }

    @Override public boolean addPatient(AddPatientDTO addPatientDTO) {

        //map the addPatientDTO with the Patient entity

        Patient patient = new Patient();

        boolean patientCreated = patientManager.addPatient( patient);
        return  patientCreated;
    }

    @Override public boolean updatePatient(String id, PatientDTO newPatientDetails) {
        return false;
    }
}
