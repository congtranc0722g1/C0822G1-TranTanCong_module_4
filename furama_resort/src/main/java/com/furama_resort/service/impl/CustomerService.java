package com.furama_resort.service.impl;

import com.furama_resort.model.customer.Customer;
import com.furama_resort.repository.ICustomerRepository;
import com.furama_resort.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Page<Customer> findAllSearch(String name, String email, String CustomerTypeId, Pageable pageable) {
        return customerRepository.findAllSearch(name, email, CustomerTypeId, pageable);
    }
}
