package com.furama_resort.controller;

import com.furama_resort.dto.ContractDto;
import com.furama_resort.model.contract.AttachFacility;
import com.furama_resort.model.contract.Contract;
import com.furama_resort.model.contract.ContractDetail;
import com.furama_resort.model.customer.Customer;
import com.furama_resort.model.employee.Employee;
import com.furama_resort.model.facility.Facility;
import com.furama_resort.service.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/contract")
public class ContractController {

    @Autowired
    private IContractService contractService;

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private IFacilityService facilityService;

    @Autowired
    private IAttachFacilityService attachFacilityService;

    @Autowired
    private IContractDetailService contractDetailService;

    @GetMapping("")
    private String showList(@PageableDefault(size = 5) Pageable pageable, Model model){
        model.addAttribute("contractDto", new ContractDto());
        model.addAttribute("contractDetail", new ContractDetail());
        Page<Contract> contractList = contractService.findAll(pageable);
        model.addAttribute("contractList", contractList);
        List<Customer> customerList = customerService.findAllCustomer();
        model.addAttribute("customerList", customerList);
        List<Employee> employeeList = employeeService.findAll();
        model.addAttribute("employeeList", employeeList);
        List<Facility> facilityList = facilityService.findAllFacility();
        model.addAttribute("facilityList", facilityList);
        List<AttachFacility> attachFacilityList = attachFacilityService.findAll();
        model.addAttribute("attachFacilityList", attachFacilityList);
        return "contract/list";
    }

    @PostMapping("/add")
    private String add (@Validated ContractDto contractDto, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model){
        Contract contract = new Contract();
        BeanUtils.copyProperties(contractDto, contract);
        contractService.save(contract);
        redirectAttributes.addFlashAttribute("mess", "Thêm mới thành công!");
        return "redirect:/contract";
    }

    @PostMapping("/add-contract-detail")
    private String addContractDetail(ContractDetail contractDetail){
        contractDetailService.add(contractDetail);
        return "redirect:/contract";
    }
}
