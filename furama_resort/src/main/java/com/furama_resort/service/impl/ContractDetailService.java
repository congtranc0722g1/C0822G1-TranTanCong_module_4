package com.furama_resort.service.impl;

import com.furama_resort.model.contract.ContractDetail;
import com.furama_resort.repository.IContractDetailRepository;
import com.furama_resort.service.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContractDetailService implements IContractDetailService {

    @Autowired
    private IContractDetailRepository contractDetailRepository;

    @Override
    public void add(ContractDetail contractDetail) {
        contractDetailRepository.save(contractDetail);
    }
}
