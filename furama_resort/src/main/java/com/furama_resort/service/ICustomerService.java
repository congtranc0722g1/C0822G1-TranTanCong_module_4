package com.furama_resort.service;

import com.furama_resort.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    void save(Customer customer);

    Page<Customer> findAllSearch(String name, String email, String CustomerTypeId, Pageable pageable);
}
