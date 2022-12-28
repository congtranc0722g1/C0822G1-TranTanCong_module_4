package com.furama_resort.service.impl;

import com.furama_resort.model.facility.RentType;
import com.furama_resort.repository.IRentTypeRepository;
import com.furama_resort.service.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentTypeService implements IRentTypeService {

    @Autowired
    private IRentTypeRepository rentTypeRepository;

    @Override
    public List<RentType> findAll() {
        return rentTypeRepository.findAll();
    }
}
