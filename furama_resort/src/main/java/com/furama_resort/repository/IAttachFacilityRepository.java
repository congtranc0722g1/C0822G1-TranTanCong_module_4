package com.furama_resort.repository;

import com.furama_resort.model.contract.AttachFacility;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAttachFacilityRepository extends JpaRepository<AttachFacility, Integer> {
}
