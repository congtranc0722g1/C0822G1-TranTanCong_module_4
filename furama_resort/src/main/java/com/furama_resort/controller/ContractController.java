package com.furama_resort.controller;

import com.furama_resort.model.contract.Contract;
import com.furama_resort.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/contract")
public class ContractController {

    @Autowired
    private IContractService contractService;

    @GetMapping("")
    private String showList(Model model){
        List<Contract> contractList = contractService.findAll();
        model.addAttribute("contractList", contractList);
        return "contract/list";
    }
}
