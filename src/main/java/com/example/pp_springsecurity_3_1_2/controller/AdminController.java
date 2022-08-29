package com.example.pp_springsecurity_3_1_2.controller;

import com.example.pp_springsecurity_3_1_2.model.User;
import com.example.pp_springsecurity_3_1_2.service.RoleServiceImpl;
import com.example.pp_springsecurity_3_1_2.service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    private final UserServiceImpl userServiceImpl;
    private final RoleServiceImpl roleServiceImpl;

    public AdminController(UserServiceImpl userServiceImpl, RoleServiceImpl roleServiceImpl) {
        this.userServiceImpl = userServiceImpl;
        this.roleServiceImpl = roleServiceImpl;
    }

    @GetMapping
    public String adminHomePage(Model model) {
        model.addAttribute("allUsers", userServiceImpl.allUsers());
        return "home";
    }

    @PostMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("roles", roleServiceImpl.getRoleList());
        return "addUser";
    }

    @PostMapping
    public String create(@ModelAttribute("user") User user) {
        userServiceImpl.addUser(user);
        return "redirect:/admin";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userServiceImpl.getUserById(id));
        model.addAttribute("roles", roleServiceImpl.getRoleList());
        return "updateUser";
    }

    @PatchMapping("{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        userServiceImpl.updateUser(user);
        return "redirect:/admin";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        userServiceImpl.deleteUserById(id);
        return "redirect:/admin";
    }
}
