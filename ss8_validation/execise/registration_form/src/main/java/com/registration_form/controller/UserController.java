package com.registration_form.controller;

import com.registration_form.dto.UserDto;
import com.registration_form.model.User;
import com.registration_form.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("")
    private String listUser(Model model){
        List<User> userList = userService.findAll();
        model.addAttribute("userList", userList);
        return "user/list";
    }

    @GetMapping("/add")
    private String showFormCreate(Model model){
        UserDto userDto = new UserDto();
        model.addAttribute("userDto", userDto);
        return "user/create";
    }

    @PostMapping("/add")
    private String add(@Validated UserDto userDto, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            return "user/create";
        }
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        userService.save(user);
        redirectAttributes.addFlashAttribute("mess", "Thêm mới thành công!");
        return "redirect:/user";
    }
}
