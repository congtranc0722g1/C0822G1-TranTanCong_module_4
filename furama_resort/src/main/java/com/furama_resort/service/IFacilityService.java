package com.furama_resort.service;

import com.furama_resort.model.facility.Facility;

import java.util.List;
import java.util.Optional;

public interface IFacilityService {
    List<Facility> findAll();

    void save(Facility facility);

    Optional<Facility> findById(Integer id);
}
