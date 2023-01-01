package com.furama_resort.repository;

import com.furama_resort.model.customer.Customer;
import com.furama_resort.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IFacilityRepository extends JpaRepository<Facility, Integer> {
    @Query(value = "select * from facility where name like concat('%', :name, '%') and facility_type_id like concat('%', :facilityTypeId, '%')", nativeQuery = true)
    Page<Facility> findAllSearch(@Param("name") String name, @Param("facilityTypeId") Integer facilityTypeId, Pageable pageable);

    @Query(value = "select * from facility where name like concat('%', :name, '%')", nativeQuery = true)
    Page<Facility> findName(@Param("name") String name, Pageable pageable);
}
