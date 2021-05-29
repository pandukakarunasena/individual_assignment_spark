package com.panduka.ncms.helpers;

import com.panduka.ncms.dto.DTO;
import com.panduka.ncms.entity.E;
import com.panduka.ncms.entity.Hospital;

public class MapperImpl implements Mapper {

    @Override public E convertToEntityObject(DTO object) {
//        if( object.getClass().getName() == "HospitalDTOImpl" ){
//            //convert to hospital entity
//            Hospital hospitalEntity = new Hospital();
//            hospitalEntity.setName();
//        }

        return null;
    }

    @Override public DTO convertToDTO(E Obj) {
        return null;
    }

}
