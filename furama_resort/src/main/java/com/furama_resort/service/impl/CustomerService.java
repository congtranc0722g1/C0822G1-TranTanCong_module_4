package com.furama_resort.service.impl;

import com.furama_resort.model.customer.Customer;
import com.furama_resort.repository.ICustomerRepository;
import com.furama_resort.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    public void save(Customer customer) {
        customerRepository.save(customer);
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

    @Override
    public Map<String, String> check(Customer customer) {
        Map<String, String> checkMap = new HashMap<>();
        for (int i = 0; i < customerRepository.findAll().size(); i++) {
            if (customer.getIdCard().equals(customerRepository.findAll().get(i).getIdCard())) {
                checkMap.put("checkIdCard", "CMND đã có trong hệ thống");
            }
            if (customer.getPhone().equals(customerRepository.findAll().get(i).getPhone())) {
                checkMap.put("checkPhone", "Số điện thoại đã có trong hệ thống");
            }
            if (customer.getEmail().equals(customerRepository.findAll().get(i).getEmail())) {
                checkMap.put("checkEmail", "Email đã có trong hệ thống");
            }
        }
        return checkMap;
    }

    @Override
    public List<Customer> findAllCustomer() {
        return customerRepository.findAll();
    }
}
