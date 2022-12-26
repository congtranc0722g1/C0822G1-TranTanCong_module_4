package com.furama_resort.repository;

import com.furama_resort.model.customer.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerTypeRepository extends JpaRepository<CustomerType, Integer> {
}
