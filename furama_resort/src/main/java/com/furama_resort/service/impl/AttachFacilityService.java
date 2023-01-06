package com.furama_resort.service.impl;

import com.furama_resort.dto.IAttachFacilityDto;
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

    @Override
    public List<IAttachFacilityDto> searchList(Integer id) {
        return attachFacilityRepository.searchList(id);
    }

    @Override
    public AttachFacility findById(Integer id) {
        return attachFacilityRepository.findById(id).orElse(null);
    }


}
