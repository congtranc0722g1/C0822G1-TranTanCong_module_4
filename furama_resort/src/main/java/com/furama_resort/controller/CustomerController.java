package com.furama_resort.controller;

import com.furama_resort.dto.CustomerDto;
import com.furama_resort.model.customer.Customer;
import com.furama_resort.model.customer.CustomerType;
import com.furama_resort.service.ICustomerService;
import com.furama_resort.service.ICustomerTypeService;
import com.furama_resort.util.IdCardException;
import com.furama_resort.util.PhoneNumberException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @Autowired
    private ICustomerTypeService customerTypeService;

    @GetMapping("")
    private  String showListCustomer(@RequestParam(name = "name", defaultValue = "") String nameSearch, @RequestParam(name = "email", defaultValue = "") String emailSearch, @RequestParam(name = "customer-type", defaultValue = "") Integer customerTypeSearch, @PageableDefault(size = 5) Pageable pageable, Model model){
        Page<Customer> customerList = customerService.findAllSearch(nameSearch, emailSearch, customerTypeSearch, pageable);
        if (nameSearch.equals("") && emailSearch.equals("") && customerTypeSearch == null){
            customerList = customerService.findAll(pageable);
        }

        if ((!nameSearch.equals("") || !emailSearch.equals("")) && customerTypeSearch == null){
            customerList = customerService.findNameEmail(nameSearch, emailSearch, pageable);
        }

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
        model.addAttribute("customerDto", new CustomerDto());
        return "customer/create";
    }

    @PostMapping("/add")
    private String add(@Validated CustomerDto customerDto, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model){
        List<CustomerType> customerTypeList = customerTypeService.findAll();
        model.addAttribute("customerTypeList", customerTypeList);
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        Map<String, String> checkList = customerService.check(customer);
        if (checkList.get("checkIdCard") != null){
            bindingResult.rejectValue("idCard", "idCard", checkList.get("checkIdCard"));
        }
        if (checkList.get("checkPhone") != null){
            bindingResult.rejectValue("phone", "phone", checkList.get("checkPhone"));
        }
        if (checkList.get("checkEmail") != null){
            bindingResult.rejectValue("email", "email", checkList.get("checkEmail"));
        }
        if (bindingResult.hasErrors()){
            return "customer/create";
        }
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("mess", "Thêm mới thành công!");
        return "redirect:/customer";
    }

   @GetMapping("/edit/{id}")
    private String showFormEdit(@PathVariable("id") int id, Model model){
       List<CustomerType> customerTypeList = customerTypeService.findAll();
       model.addAttribute("customerTypeList", customerTypeList);
        Optional<Customer> customer = customerService.findById(id);
        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(customer.get(), customerDto);
        model.addAttribute("customerDto", customerDto);
        return "customer/edit";
    }

    @PostMapping("/edit")
    private String update(@Validated CustomerDto customerDto, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            return "customer/edit";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        customerService.update(customer);
        redirectAttributes.addFlashAttribute("mess", "Chỉnh sửa thành công!");
        return "redirect:/customer";
    }

    @PostMapping("/delete")
    private String delete(@RequestParam("id") int id, RedirectAttributes redirectAttributes){
        Optional<Customer> customer = customerService.findById(id);
        customerService.delete(customer.get());
        redirectAttributes.addFlashAttribute("mess", "Xóa thành công!");
        return "redirect:/customer";
    }
}
