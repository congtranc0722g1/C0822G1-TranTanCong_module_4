package com.furama_resort.service;

import com.furama_resort.model.customer.CustomerType;

import java.util.List;

public interface ICustomerTypeService {
    List<CustomerType> findAll();
}
