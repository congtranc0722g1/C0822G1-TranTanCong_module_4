package com.configuring_email.controller;

import com.configuring_email.model.ConfiguringEmail;
import com.configuring_email.service.IConfiguringEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("")
public class ConfiguringEmailController {

    @Autowired
    private IConfiguringEmailService configuringEmailService;

    @GetMapping("")
    private String listConfigurationEmail(Model model) {
        List<ConfiguringEmail> configuringEmailList = configuringEmailService.showAll();
        model.addAttribute("configuringEmailList", configuringEmailList);
        return "/email/list";
    }

    @GetMapping("/edit/{id}")
    private String showFormEditConfigurationEmail(@PathVariable("id") int id, Model model) {
        List<String> languageList = new ArrayList<>();
        languageList.add("English");
        languageList.add("Vietnamese");
        languageList.add("Japanese");
        languageList.add("Chinese");
        model.addAttribute("languageList", languageList);


        List<Integer> pageSizeList = new ArrayList<>();
        pageSizeList.add(5);
        pageSizeList.add(10);
        pageSizeList.add(15);
        pageSizeList.add(25);
        pageSizeList.add(50);
        pageSizeList.add(100);
        model.addAttribute("pageSizeList", pageSizeList);


        ConfiguringEmail configuringEmail = configuringEmailService.findById(id);
        model.addAttribute("configuringEmail", configuringEmail);
        return "/email/configuring";
    }

    @PostMapping("/edit")
    private String update(ConfiguringEmail configuringEmail, Model model, RedirectAttributes redirectAttributes) {
        configuringEmailService.update(configuringEmail);
        redirectAttributes.addFlashAttribute("mess", "Update successful!");
        return "redirect:/";
    }


}
