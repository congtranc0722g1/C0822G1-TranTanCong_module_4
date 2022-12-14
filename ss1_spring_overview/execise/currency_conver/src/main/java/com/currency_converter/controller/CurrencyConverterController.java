package com.currency_converter.controller;

import com.currency_converter.service.IConvertService;
import com.currency_converter.service.impl.ConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("")
public class CurrencyConverterController {
    @Autowired
    private IConvertService convertService;

    @RequestMapping("")
    public String convert() {
        return "currency_converter/convert";
    }

    @RequestMapping(value = "/convert-usd-to-vnd", method = RequestMethod.POST)
    public String convertUsdToVnd(double usd, Model model) {
        double result = convertService.convertUsdToVnd(usd);
        model.addAttribute("result", result + " VNĐ");
        return "currency_converter/convert";
    }

    @RequestMapping(value = "/convert-vnd-to-usd", method = RequestMethod.POST)
    public String convertVndToUsd(double vnd, Model model) {
        double result = convertService.convertVndToUsd(vnd);
        model.addAttribute("result", result + " USD");
        return "currency_converter/convert";
    }

}
