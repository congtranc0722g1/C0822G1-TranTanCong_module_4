package com.furama_resort.repository;

import com.furama_resort.model.contract.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IContractRepository extends JpaRepository<Contract, Integer> {
}
