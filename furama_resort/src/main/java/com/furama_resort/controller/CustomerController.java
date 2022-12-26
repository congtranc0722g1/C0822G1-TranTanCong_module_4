package com.furama_resort.controller;

import com.furama_resort.model.customer.Customer;
import com.furama_resort.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @GetMapping("")
    private  String showListCustomer(Model model){
        List<Customer> customerList = customerService.findAll();
        model.addAttribute("customerList", customerList);
        return "customer/list";
    }

   @GetMapping("/add")
    private String showFormCreate(Model model){
        model.addAttribute("customer", new Customer());
        return "customer/create";
    }
}
