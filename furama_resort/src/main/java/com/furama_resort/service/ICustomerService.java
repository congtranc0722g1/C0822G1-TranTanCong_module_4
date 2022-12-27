package com.furama_resort.service;

import com.furama_resort.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    List<Customer> findAll();

    void save(Customer customer);

    Page<Customer> findAllSearch(String name, String email, String customerTypeId, Pageable pageable);

    Optional<Customer> findById(int id);

    void delete(Customer customer);
}
