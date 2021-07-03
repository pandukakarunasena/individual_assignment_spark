package com.panduka.ncms.services.hospital;

import com.panduka.ncms.dao.HospitalDAO;
import com.panduka.ncms.dao.impl.HospitalDAOImpl;
import com.panduka.ncms.dto.HospitalDTO;

import com.panduka.ncms.dto.PatientDTO;
import com.panduka.ncms.entity.Hospital;
import com.panduka.ncms.entity.Patient;
import com.panduka.ncms.helpers.Mapper;
import java.util.ArrayList;
import java.util.List;

public class HospitalServiceImpl implements HospitalService{

    HospitalDAO hospitalManager = new HospitalDAOImpl();

    @Override
    public List<HospitalDTO> getAllHospitals() {
        System.out.println("get all hospitals service");
        List<Hospital> hospitals = hospitalManager.getAllHospitals();
        List<HospitalDTO> hospitalsConverted = new ArrayList<>();

        for( Hospital hospitalEntity: hospitals){
            HospitalDTO newHospitalDTO =(HospitalDTO) Mapper.convertToDTO( hospitalEntity);
            hospitalsConverted.add( newHospitalDTO);
        }

        return hospitalsConverted;
    }

    @Override
    public HospitalDTO getHospitalById(String id) {

        HospitalDTO hospitalDTO = (HospitalDTO) Mapper.convertToDTO(hospitalManager.getHospitalById(id));

        return hospitalDTO;
    }

    @Override public HospitalDTO createHospital(HospitalDTO newHospitalDTO) {
        Hospital newHospitalEntity =(Hospital) Mapper.convertToEntityObject( newHospitalDTO);

        hospitalManager.saveHospital(newHospitalEntity);

        //convert the returned entity object to DTO before returning
        return newHospitalDTO;
    }

    @Override public boolean deleteHospitalById(String id) {
        boolean deleted = hospitalManager.deleteHospital(id);

        return deleted;
    }

    @Override public List<PatientDTO> getPatientsByHospital(String id) {
        List<Patient> patientListByHospital = hospitalManager.getPatientsByHospital( id);

        List< PatientDTO> patientDTOListByHospital = new ArrayList<>();

        for ( Patient p: patientListByHospital){
            PatientDTO patientDTO = (PatientDTO) Mapper.convertToDTO( p);
            patientDTOListByHospital.add( patientDTO);
        }

        return patientDTOListByHospital;
    }

}
