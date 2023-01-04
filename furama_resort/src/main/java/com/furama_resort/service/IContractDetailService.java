package com.furama_resort.service;

import com.furama_resort.model.contract.ContractDetail;

import java.util.List;

public interface IContractDetailService {
    void add(ContractDetail contractDetail);

    List<ContractDetail> search(Integer id);
}
