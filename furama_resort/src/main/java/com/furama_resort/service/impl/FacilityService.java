package com.furama_resort.service.impl;

import com.furama_resort.model.customer.Customer;
import com.furama_resort.model.facility.Facility;
import com.furama_resort.repository.IFacilityRepository;
import com.furama_resort.service.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacilityService implements IFacilityService {

    @Autowired
    private IFacilityRepository facilityRepository;

    @Override
    public Page<Facility> findAll(Pageable pageable) {
        return facilityRepository.findAll(pageable);
    }

    @Override
    public void save(Facility facility) {
        facilityRepository.save(facility);
    }

    @Override
    public Optional<Facility> findById(Integer id) {
        return facilityRepository.findById(id);
    }

    @Override
    public void delete(Integer id) {
        facilityRepository.deleteById(id);
    }

    @Override
    public Page<Facility> findAllSearch(String name, Integer facilityTypeId, Pageable pageable) {
        return facilityRepository.findAllSearch(name, facilityTypeId, pageable);
    }

    @Override
    public Page<Facility> findName(String name, Pageable pageable) {
        return facilityRepository.findName(name, pageable);
    }
}
