package com.furama_resort.service;

import com.furama_resort.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IFacilityService {
    Page<Facility> findAll(Pageable pageable);

    void save(Facility facility);

    Optional<Facility> findById(Integer id);

    void delete(Integer id);

    Page<Facility> findAllSearch(String name, Integer facilityTypeId, Pageable pageable);

    Page<Facility> findName(String name, Pageable pageable);

    void check (Facility facility) throws Exception;

    List<Facility> findAllFacility();
}
