package com.panduka.ncms.helpers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.panduka.ncms.dto.HospitalDTO;
import com.panduka.ncms.dto.impl.HospitalDTOImpl;
import com.panduka.ncms.entity.Hospital;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MapperTest {
    private HospitalDTOImpl hospitalDTO;
    private Hospital hospital;

    @BeforeEach
    public void setUp() throws Exception {
        hospitalDTO = new HospitalDTOImpl();
        hospital = new Hospital();
    }

    @Test
    void TestConvertToEntityObjectTest( ) {
       assertEquals( hospital, Mapper.convertToEntityObject( hospitalDTO));
    }

    @Test
    void TestConvertToDTO() {

    }

}