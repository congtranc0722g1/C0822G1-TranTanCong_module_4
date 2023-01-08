package com.furama_resort.service;

import com.furama_resort.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ICustomerService {
    Page<Customer> findAll(Pageable pageable);

    void save(Customer customer);

    void update(Customer customer);

    Page<Customer> findAllSearch(String name, String email, Integer customerTypeId, Pageable pageable);

    Page<Customer> findNameEmail(String name, String email, Pageable pageable);

    Optional<Customer> findById(int id);

    void delete(Customer customer);

    List<Customer> findAllCustomer();

    Map<String, String> check(Customer customer);
}
