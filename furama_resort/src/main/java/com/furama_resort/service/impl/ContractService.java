package com.furama_resort.service.impl;

import com.furama_resort.model.contract.Contract;
import com.furama_resort.repository.IContractRepository;
import com.furama_resort.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService implements IContractService {

    @Autowired
    private IContractRepository contractRepository;

    @Override
    public List<Contract> findAll() {
        return contractRepository.findAll();
    }
}
