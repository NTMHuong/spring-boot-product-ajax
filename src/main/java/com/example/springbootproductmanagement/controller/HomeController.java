package com.example.springbootproductmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@CrossOrigin("*")
public class HomeController {
    @GetMapping
    public String show(){
        return "product/list";
    }

    @GetMapping("/api/login")
    public String loginPage(){
        return "/login";
    }
}
