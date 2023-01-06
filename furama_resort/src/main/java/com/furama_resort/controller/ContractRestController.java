package com.furama_resort.controller;

import com.furama_resort.dto.ContractDetailDto;
import com.furama_resort.dto.IAttachFacilityDto;
import com.furama_resort.dto.IContractDto;
import com.furama_resort.model.contract.AttachFacility;
import com.furama_resort.model.contract.Contract;
import com.furama_resort.model.contract.ContractDetail;
import com.furama_resort.service.IAttachFacilityService;
import com.furama_resort.service.IContractDetailService;
import com.furama_resort.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/contracts")
public class ContractRestController {

    @Autowired
    private IAttachFacilityService attachFacilityService;

    @Autowired
    private IContractService contractService;

    @Autowired
    private IContractDetailService contractDetailService;

    @GetMapping("")
    private ResponseEntity<List<IContractDto>> showList(){
        List<IContractDto> contractDtoList = contractService.showList();
        if (contractDtoList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(contractDtoList, HttpStatus.OK);
    }

    @GetMapping("/attach-facility/search/{id}")
    private ResponseEntity<List<IAttachFacilityDto>> search(@PathVariable("id") Integer id){
        List<IAttachFacilityDto> attachFacilityList = attachFacilityService.searchList(id);
        if (attachFacilityList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(attachFacilityList, HttpStatus.OK);
    }

    @PostMapping("/contract-detail/add")
    private ResponseEntity<?> add(@RequestBody ContractDetailDto contractDetailDto){
        ContractDetail contractDetail = new ContractDetail();
        contractDetail.setQuantity(contractDetailDto.getQuantity());
        contractDetail.setContract(contractService.findById(contractDetailDto.getContract()));
        contractDetail.setAttachFacility(attachFacilityService.findById(contractDetailDto.getAttachFacility()));
        contractDetailService.add(contractDetail);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
