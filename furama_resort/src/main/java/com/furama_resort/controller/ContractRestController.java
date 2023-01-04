package com.furama_resort.controller;

import com.furama_resort.model.contract.ContractDetail;
import com.furama_resort.service.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/attach-facility")
public class ContractRestController {

    @Autowired
    private IContractDetailService contractDetailService;

    @GetMapping("/search/{id}")
    private ResponseEntity<List<ContractDetail>> search(@PathVariable("id") Integer id){
        List<ContractDetail> contractDetailList = contractDetailService.search(id);
        if (contractDetailList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(contractDetailList, HttpStatus.OK);
    }
}
