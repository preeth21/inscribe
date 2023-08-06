package com.tony.inscribe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MainController {

    @GetMapping("/")
    public String login() {

        return "login";
    }

    @GetMapping("/register")
    public String register(){

        return "registration";
    }


    @GetMapping("/home")
    public String home(){

        return "home";
    }
}
