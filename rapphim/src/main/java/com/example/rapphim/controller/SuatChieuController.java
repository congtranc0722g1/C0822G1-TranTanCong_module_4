package com.example.rapphim.controller;

import com.example.rapphim.model.Phim;
import com.example.rapphim.model.SuatChieu;
import com.example.rapphim.service.IPhimService;
import com.example.rapphim.service.ISuatChieuService;
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
@RequestMapping("")
public class SuatChieuController {

    @Autowired
    private ISuatChieuService suatChieuService;

    @Autowired
    private IPhimService phimService;

    @GetMapping("")
    private String showList(@PageableDefault(size = 2)Pageable pageable, Model model){
        Page<SuatChieu> suatChieuList = suatChieuService.findAll(pageable);
        model.addAttribute("suatChieuList", suatChieuList);
        return "list";
    }

    @PostMapping("/delete")
    private String delete(@RequestParam(name = "id", defaultValue = "") String ma){
        SuatChieu suatChieu = suatChieuService.findByMa(ma);
        suatChieuService.delete(suatChieu);
        return "redirect:/";
    }

    @GetMapping("/add")
    private String showFormAdd(Model model){
        List<Phim> phimList = phimService.findAll();
        model.addAttribute("phimList", phimList);
        model.addAttribute("suatChieu", new SuatChieu());
        return "create";
    }

    @PostMapping("/add")
    private String add(SuatChieu suatChieu){
        suatChieuService.save(suatChieu);
        return "redirect:/";
    }
}
