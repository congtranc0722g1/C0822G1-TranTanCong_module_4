package com.furama_resort.service.impl;

import com.furama_resort.model.facility.Facility;
import com.furama_resort.repository.IFacilityRepository;
import com.furama_resort.service.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityService implements IFacilityService {

    @Autowired
    private IFacilityRepository facilityRepository;

    @Override
    public List<Facility> findAll() {
        return facilityRepository.findAll();
    }
}
