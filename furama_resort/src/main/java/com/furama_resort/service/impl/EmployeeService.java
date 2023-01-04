package com.furama_resort.service.impl;

import com.furama_resort.model.employee.Employee;
import com.furama_resort.repository.IEmployeeRepository;
import com.furama_resort.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private IEmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }
}
