package com.furama_resort.service.impl;

import com.furama_resort.model.customer.Customer;
import com.furama_resort.repository.ICustomerRepository;
import com.furama_resort.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public Boolean save(Customer customer) {
        for (int i = 0; i < customerRepository.findAll().size(); i++) {
            if (customer.getIdCard().equals(customerRepository.findAll().get(i).getIdCard()) || customer.getPhone().equals(customerRepository.findAll().get(i).getPhone()) || customer.getEmail().equals(customerRepository.findAll().get(i).getEmail())){
                return false;

            }
        }
        customerRepository.save(customer);
        return true;
    }

    @Override
    public void update(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Page<Customer> findAllSearch(String name, String email, Integer customerTypeId, Pageable pageable) {
        return customerRepository.findAllSearch(name, email, customerTypeId, pageable);
    }

    @Override
    public Page<Customer> findNameEmail(String name, String email, Pageable pageable) {
        return customerRepository.findNameEmail(name, email, pageable);
    }

    @Override
    public Optional<Customer> findById(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public void delete(Customer customer) {
        customerRepository.delete(customer);
    }
}
