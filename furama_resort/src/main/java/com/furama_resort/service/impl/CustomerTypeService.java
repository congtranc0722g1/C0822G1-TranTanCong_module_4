package com.furama_resort.service.impl;

import com.furama_resort.model.customer.CustomerType;
import com.furama_resort.repository.ICustomerTypeRepository;
import com.furama_resort.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTypeService implements ICustomerTypeService {

    @Autowired
    private ICustomerTypeRepository customerTypeRepository;

    @Override
    public List<CustomerType> findAll() {
        return customerTypeRepository.findAll();
    }
}
