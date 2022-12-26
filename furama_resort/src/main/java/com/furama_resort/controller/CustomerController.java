package com.furama_resort.controller;

import com.furama_resort.model.customer.Customer;
import com.furama_resort.model.customer.CustomerType;
import com.furama_resort.service.ICustomerService;
import com.furama_resort.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @Autowired
    private ICustomerTypeService customerTypeService;

    @GetMapping("")
    private  String showListCustomer(@RequestParam(name = "name", defaultValue = "") String nameSearch, @RequestParam(name = "email", defaultValue = "") String emailSearch, @RequestParam(name = "customer-type", defaultValue = "") String customerTypeSearch, @PageableDefault(size = 5) Pageable pageable, Model model){
        Page<Customer> customerList = customerService.findAllSearch(nameSearch, emailSearch, customerTypeSearch, pageable);
        model.addAttribute("customerList", customerList);
        model.addAttribute("nameSearch", nameSearch);
        model.addAttribute("emailSearch", emailSearch);
        model.addAttribute("customerTypeSearch", customerTypeSearch);
        List<CustomerType> customerTypeList = customerTypeService.findAll();
        model.addAttribute("customerTypeList", customerTypeList);
        return "customer/list";
    }

   @GetMapping("/add")
    private String showFormCreate(Model model){
        List<CustomerType> customerTypeList = customerTypeService.findAll();
        model.addAttribute("customerTypeList", customerTypeList);
        model.addAttribute("customer", new Customer());
        return "customer/create";
    }

    @PostMapping("/add")
    private String add(Customer customer){
        customerService.save(customer);
        return "redirect:/customer";
    }
}
