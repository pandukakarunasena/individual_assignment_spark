package com.panduka.ncms.helpers;

import com.panduka.ncms.dto.HospitalDTO;
import com.panduka.ncms.dto.PatientDTO;
import com.panduka.ncms.dto.UserDTO;
import com.panduka.ncms.dto.impl.HospitalDTOImpl;
import com.panduka.ncms.dto.impl.PatientDTOImpl;
import com.panduka.ncms.dto.impl.UserDTOImpl;
import com.panduka.ncms.entity.Hospital;
import com.panduka.ncms.entity.Patient;
import com.panduka.ncms.entity.User;

import java.util.ArrayList;
import java.util.List;

public class Mapper {

    public static Object convertToEntityObject(Object dto) {

        if (dto instanceof HospitalDTOImpl) {
            Hospital hospitalEntity = new Hospital();
            HospitalDTO hospitalDTO = (HospitalDTO) dto;

            hospitalEntity.setName(hospitalDTO.getName());
            hospitalEntity.setLocationY(hospitalDTO.getY());
            hospitalEntity.setLocationX(hospitalDTO.getX());
            hospitalEntity.setChiefDoctor((User) Mapper.convertToEntityObject(hospitalDTO.getChiefDoctor()));
            hospitalEntity.setAvailBeds(hospitalDTO.getNoOfBeds());

            //id is generated by the hibernate itself
            //build date is only needed when creating the hospital

            return hospitalEntity;
        }
        if (dto instanceof PatientDTOImpl) {

        }
        if (dto instanceof UserDTOImpl) {

        }
        if (dto instanceof PatientDTOImpl) {

        }

        return null;
    }

    public static Object convertToDTO(Object entity) {

        if (entity instanceof User) {
            UserDTO userDTO = new UserDTOImpl();
            User userEntity = (User) entity;

            userDTO.setId(userEntity.getId());
            userDTO.setFirstName(userEntity.getFirstName());
            userDTO.setLastName(userEntity.getLastName());
            userDTO.setRole(userEntity.getRole());

            return userDTO;
        }
        if (entity instanceof Patient) {
            PatientDTO patientDTO = new PatientDTOImpl();
            Patient patient = (Patient) entity;

            patientDTO.setId(patient.getId());
            patientDTO.setFirstName(patient.getFirstName());
            patientDTO.setLastName(patient.getLastName());
            patientDTO.setAdmitDate(patient.getAdmitDate());
            patientDTO.setAge(patient.getAge());
            patientDTO.setBedNo(patient.getBedNo());
            patientDTO.setDischargedDate(patient.getDischargedDate());
            patientDTO.setDistrict(patient.getDistrict());
            patientDTO.setEmail(patient.getEmail());
            patientDTO.setGender(patient.getGender());
            patientDTO.setContact(patient.getContact());
            patientDTO.setLocationX(patient.getLocationX());
            patientDTO.setLocationY(patient.getLocationY());
            patientDTO.setSeverityLevel(patient.getSeverityLevel());

            patientDTO.setAdmittedBy((UserDTO) Mapper.convertToDTO(patient.getAdmittedBy()));
            patientDTO.setDischargedBy((UserDTO) Mapper.convertToDTO(patient.getDischargedBy()));
            //patientDTO.setHospital( (HospitalDTO) Mapper.convertToDTO( patient.getHospital()));
            //patientDTO.setPatientQueue( (PatientDTO) Mapper.convertToDTO( patient.getPatientQueue()));

            return patientDTO;

        }

        return null;
    }

}
