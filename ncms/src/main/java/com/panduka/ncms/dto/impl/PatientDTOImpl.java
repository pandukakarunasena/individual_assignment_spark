package com.panduka.ncms.dto.impl;

import com.panduka.ncms.dto.DTO;
import java.io.Serializable;

public class PatientDTOImpl implements Serializable, DTO {
    String serialNumber;
    String bedNo;
    String hospital;
    String queueNo;

}
