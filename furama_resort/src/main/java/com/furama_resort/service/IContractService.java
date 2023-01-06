package com.furama_resort.service;

import com.furama_resort.dto.IContractDto;
import com.furama_resort.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractService {
    Page<Contract> findAll(Pageable pageable);

    void save(Contract contract);

    List<IContractDto> showList();

    Contract findById(Integer id);
}
