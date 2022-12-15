package com.sandwich.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class SandwichController {

    @GetMapping("")
    private String spiceDisplay() {
        return "/sandwich/order";
    }

    @PostMapping("/order")
    private String spiceDisplay(String lettuce, String tomato, String mustard, String sprouts, Model model) {
        model.addAttribute("lettuce", lettuce);
        model.addAttribute("tomato", tomato);
        model.addAttribute("mustard", mustard);
        model.addAttribute("sprouts", sprouts);
        return "/sandwich/list";
    }
}
