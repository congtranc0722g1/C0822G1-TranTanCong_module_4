package com.furama_resort.controller;

import com.furama_resort.dto.FacilityDto;
import com.furama_resort.model.facility.Facility;
import com.furama_resort.model.facility.FacilityType;
import com.furama_resort.model.facility.RentType;
import com.furama_resort.service.IFacilityService;
import com.furama_resort.service.IFacilityTypeService;
import com.furama_resort.service.IRentTypeService;
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

import java.util.List;

@Controller
@RequestMapping("/facility")
public class FacilityController {

    @Autowired
    private IFacilityService facilityService;

    @Autowired
    private IFacilityTypeService facilityTypeService;

    @Autowired
    private IRentTypeService rentTypeService;

    @GetMapping("")
    private String showList(@RequestParam(name = "name", defaultValue = "") String nameSearch, @RequestParam(name = "facility-type", defaultValue = "") Integer facilityTypeSearch, @PageableDefault(size = 5) Pageable pageable, Model model){
        Page<Facility> facilityList = facilityService.findAllSearch(nameSearch, facilityTypeSearch, pageable);
        if (nameSearch.equals("") && facilityTypeSearch == null){
            facilityList = facilityService.findAll(pageable);
        }

        if (!nameSearch.equals("") && facilityTypeSearch == null){
            facilityList = facilityService.findName(nameSearch, pageable);
        }

        List<FacilityType> facilityTypeList = facilityTypeService.findAll();
        model.addAttribute("facilityTypeList", facilityTypeList);

        model.addAttribute("facilityList", facilityList);

        model.addAttribute("facilityTypeSearch", facilityTypeSearch);

        model.addAttribute("nameSearch", nameSearch);

        return "facility/list";
    }

    @GetMapping("/add")
    private String showFormCreate(Model model){
        model.addAttribute("facilityDto", new FacilityDto());
        List<FacilityType> facilityTypeList = facilityTypeService.findAll();
        model.addAttribute("facilityTypeList", facilityTypeList);
        List<RentType> rentTypeList = rentTypeService.findAll();
        model.addAttribute("rentTypeList", rentTypeList);
        return "facility/create";
    }

    @PostMapping("/add")
    private String add(@Validated FacilityDto facilityDto, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            return "facility/create";
        }
        Facility facility = new Facility();
        BeanUtils.copyProperties(facilityDto, facility);
        facilityService.save(facility);
        redirectAttributes.addFlashAttribute("mess", "Thêm mới thành công!");
        return "redirect:/facility";
    }

    @GetMapping("/edit/{id}")
    private String showFormEdit(@PathVariable("id") Integer id, Model model){
        List<RentType> rentTypeList = rentTypeService.findAll();
        model.addAttribute("rentTypeList", rentTypeList);
        List<FacilityType> facilityTypeList = facilityTypeService.findAll();
        model.addAttribute("facilityTypeList", facilityTypeList);
        Facility facility = facilityService.findById(id).get();
        FacilityDto facilityDto = new FacilityDto();
        BeanUtils.copyProperties(facility, facilityDto);
        model.addAttribute("facilityType", facilityDto.getFacilityType().getId());
        model.addAttribute("facilityDto", facilityDto);
        return "facility/edit";
    }

    @PostMapping("/edit")
    private String edit(@Validated FacilityDto facilityDto, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        Facility facility = new Facility();
        BeanUtils.copyProperties(facilityDto, facility);
        facilityService.save(facility);
        redirectAttributes.addFlashAttribute("mess", "Chỉnh sửa thành công!");
        return "redirect:/facility";
    }

    @PostMapping("/delete")
    private String delete(@RequestParam(value = "id", defaultValue = "-1") Integer id, RedirectAttributes redirectAttributes){
        facilityService.delete(id);
        redirectAttributes.addFlashAttribute("mess", "Xóa thành công!");
        return "redirect:/facility";
    }
}
