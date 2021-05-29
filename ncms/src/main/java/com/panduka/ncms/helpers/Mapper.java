package com.panduka.ncms.helpers;

import com.panduka.ncms.dto.DTO;
import com.panduka.ncms.entity.E;

public interface Mapper {
    E convertToEntityObject(DTO object );
    DTO convertToDTO( E Obj);
}
