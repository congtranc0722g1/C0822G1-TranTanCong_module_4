package com.furama_resort.service;

import com.furama_resort.dto.IAttachFacilityDto;
import com.furama_resort.model.contract.AttachFacility;

import java.util.List;

public interface IAttachFacilityService {
    List<AttachFacility> findAll();

    List<IAttachFacilityDto> searchList(Integer id);

    AttachFacility findById(Integer id);
}
