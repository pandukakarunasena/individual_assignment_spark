package com.panduka.ncms.services.hospital;

import com.panduka.ncms.dao.PatientDAO;
import com.panduka.ncms.dao.impl.BedDAOImpl;
import com.panduka.ncms.dao.impl.HospitalDAOImpl;
import com.panduka.ncms.dao.impl.PatientDAOImpl;
import com.panduka.ncms.dto.AddPatientDTO;
import com.panduka.ncms.dto.PatientDTO;
import com.panduka.ncms.dto.impl.PatientClient;
import com.panduka.ncms.entity.Bed;
import com.panduka.ncms.entity.Patient;
import com.panduka.ncms.helpers.BedBooking;
import com.panduka.ncms.helpers.BedBookingProxyImpl;
import com.panduka.ncms.helpers.Mapper;
import java.util.ArrayList;
import java.util.List;

public class PatientServiceImpl implements PatientService {

    PatientDAO patientManager = new PatientDAOImpl();

    @Override public PatientClient getPatientById(String id) {
        Patient patient = patientManager.getPatientById(id);
        System.out.println("patient service getPatientById method" + patient);
        if (patient == null) {
            return null;
        }

        //set patient list as null before sending to a normal patient registration request
        patient.getHospital().setPatientList(null);

        PatientClient patientToClient = new PatientClient(patient.getId(), patient.getFirstName(),
                patient.getLastName(), patient.getAge(), patient.getGender(), patient.getEmail(), patient.getContact(),
                patient.getDistrict(), patient.getHospital().getName(), patient.getBedNo().getId(),
                patient.getLocationX(), patient.getLocationY()

        );

        return patientToClient;
    }

    @Override public boolean deletePatient(String id) {
        boolean deleted = patientManager.deletePatient(id);
        return deleted;
    }

    @Override public List<PatientDTO> getPatientBySeverity(String severity) {
        List<Patient> patientListBySeverity = patientManager.getPatientBySeverity(severity);
        List<PatientDTO> patientDTOListBySeverity = new ArrayList<>();
        for (Patient p : patientListBySeverity) {
            PatientDTO patientDTO = (PatientDTO) Mapper.convertToDTO(p);
            patientDTOListBySeverity.add(patientDTO);
        }

        return patientDTOListBySeverity;
    }

    @Override public List<PatientDTO> getAllPatients() {
        List<Patient> patientList = patientManager.getAllPatients();
        System.out.println("patient service get all method" + patientList);

        List<PatientDTO> patientDTOList = new ArrayList<>();
        for (Patient p : patientList) {
            PatientDTO patientDTO = (PatientDTO) Mapper.convertToDTO(p);
            patientDTOList.add(patientDTO);
        }

        return patientDTOList;

    }

    @Override public String addPatient(AddPatientDTO addPatientDTO) {

        //select a hospital and a bed no
        //fill a bed in a hospital and get the hospital ID and the Bed ID
        //return it here
        //send to create a pa
        BedBooking bedBooking = new BedBookingProxyImpl();
        List<String> bookingDetails = bedBooking.bookABed(addPatientDTO.getX(), addPatientDTO.getY());

        String hospitalId = bookingDetails.get(0);
        int bedNo = Integer.parseInt(bookingDetails.get(1));
        System.out.println(hospitalId);
        System.out.println(bedNo);
        BedDAOImpl bedDAOImpl = new BedDAOImpl();
        bedDAOImpl.reserveBed(bedNo);

        Bed bookedBed = bedDAOImpl.getBedById(bedNo);

        Patient patient = new Patient(addPatientDTO.getDistrict(), addPatientDTO.getFirstName(),
                addPatientDTO.getLastName(), addPatientDTO.getX(), addPatientDTO.getY(), addPatientDTO.getGender(),
                addPatientDTO.getContact(), addPatientDTO.getEmail(), addPatientDTO.getAge(), bookedBed,
                new HospitalDAOImpl().getHospitalById(hospitalId));

        String patientCreatedSerialNumber = patientManager.savePatient(patient);
        return patientCreatedSerialNumber;
    }

    @Override public boolean updatePatient(String id, PatientDTO newPatientDetails) {
        //add the admitted date,admitted by, severity at the entrance by a doctor
        //update the discharged date discharged by after a doctor discharges the patient

        return false;
    }

}
