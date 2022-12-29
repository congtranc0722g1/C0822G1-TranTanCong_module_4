package com.furama_resort.service;

import com.furama_resort.model.contract.Contract;

import java.util.List;

public interface IContractService {
    List<Contract> findAll();
}
