package com.bootstrap.roman.controller;

import com.bootstrap.roman.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getUserPage(ModelMap modelMap, Principal principal) {
        modelMap.addAttribute("userThis", userService.loadUserByUsername(principal.getName()));
        return "static/userPage";
    }
}
