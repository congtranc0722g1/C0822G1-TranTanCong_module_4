package com.caculator.controller;

import com.caculator.service.ICaculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("")
@Controller
public class CaculatorController {

    @Autowired
    private ICaculatorService caculatorService;

    @GetMapping("")
    private String calculate() {
        return "/caculator/calculate";
    }

    @GetMapping("/calculate")
    private String calculate(@RequestParam(value = "first-number") Double firstNumber, char calculations, @RequestParam(value = "second-number") Double secondNumber, Model model) {

        double result = 0;
        try {
            result = caculatorService.calculate(firstNumber, calculations, secondNumber);
        } catch (RuntimeException e) {
            model.addAttribute("exception", e.getMessage());
        }
        model.addAttribute("result", result);
        return "/caculator/calculate";
    }
}
