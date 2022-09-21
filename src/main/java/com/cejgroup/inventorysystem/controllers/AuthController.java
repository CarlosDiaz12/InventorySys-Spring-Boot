package com.cejgroup.inventorysystem.controllers;

import com.cejgroup.inventorysystem.domain.interfaces.User.IUserService;
import com.cejgroup.inventorysystem.dto.RegisterUserDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {
    private IUserService userService;

    public AuthController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/auth/register")
    public String registerUser(Model model){
        model.addAttribute("user", new RegisterUserDto());
        return "/auth/register";
    }

    @PostMapping("/auth/register")
    public String registerUser(@ModelAttribute("user")RegisterUserDto registerUserDto){
        userService.register(registerUserDto);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginUser(){
        return "/auth/login";
    }
}
