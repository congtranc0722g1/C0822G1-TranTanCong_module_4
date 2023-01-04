package com.furama_resort.service.impl;

import com.furama_resort.model.contract.AttachFacility;
import com.furama_resort.repository.IAttachFacilityRepository;
import com.furama_resort.service.IAttachFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachFacilityService implements IAttachFacilityService {

    @Autowired
    private IAttachFacilityRepository attachFacilityRepository;

    @Override
    public List<AttachFacility> findAll() {
        return attachFacilityRepository.findAll();
    }
}
