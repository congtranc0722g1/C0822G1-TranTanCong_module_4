package com.furama_resort.service;

import com.furama_resort.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IContractService {
    Page<Contract> findAll(Pageable pageable);

    void save(Contract contract);
}
