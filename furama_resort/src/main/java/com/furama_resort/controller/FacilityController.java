package com.furama_resort.controller;

import com.furama_resort.model.facility.Facility;
import com.furama_resort.service.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/facility")
public class FacilityController {

    @Autowired
    private IFacilityService facilityService;

    @GetMapping("")
    private String showList(Model model){
        List<Facility> facilityList = facilityService.findAll();
        model.addAttribute("facilityList", facilityList);
        return "facility/list";
    }
}
