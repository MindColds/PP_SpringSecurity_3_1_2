package com.example.pp_springsecurity_3_1_2.controller;

import com.example.pp_springsecurity_3_1_2.model.User;
import com.example.pp_springsecurity_3_1_2.service.PrivateUserDetailsService;
import com.example.pp_springsecurity_3_1_2.service.UserServiceImpl;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value = "/user")
public class UserController {
    private final UserServiceImpl userServiceImpl;
    private final PrivateUserDetailsService privateUserDetailsService;


    public UserController(UserServiceImpl userServiceImpl, PrivateUserDetailsService privateUserDetailsService) {
        this.userServiceImpl = userServiceImpl;
        this.privateUserDetailsService = privateUserDetailsService;
    }

    @GetMapping
    public String user(Model model) {
        String principalName = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = (User) privateUserDetailsService.loadUserByUsername(principalName);
        model.addAttribute("user", user);
        return "user";
    }
}
