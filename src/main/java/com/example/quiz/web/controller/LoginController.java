package com.example.quiz.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/auth")
    public String loginPage() {
        return "auth";
    }
}