package com.furama_resort.service.impl;

import com.furama_resort.model.facility.FacilityType;
import com.furama_resort.repository.IFacilityTypeRepository;
import com.furama_resort.service.IFacilityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityTypeService implements IFacilityTypeService {

    @Autowired
    private IFacilityTypeRepository facilityTypeRepository;

    @Override
    public List<FacilityType> findAll() {
        return facilityTypeRepository.findAll();
    }
}
