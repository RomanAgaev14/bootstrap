package com.bootstrap.roman.controller;


import com.bootstrap.roman.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {
    private final UserService userService;

    @Autowired
    public HelloController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/hello")
    public String getHelloPage(Model model, Principal principal) {
        List<String> messages = new ArrayList<>();
        messages.add("Привет");
        messages.add("Ты бы знал, как я устал делать это дерьмо");
        messages.add("Спасибо за внимание!");

        model.addAttribute("messages", messages);
        if (principal != null) {
            model.addAttribute("userThis", userService.loadUserByUsername(principal.getName()));
        }

        return "static/helloPage";
    }
}
