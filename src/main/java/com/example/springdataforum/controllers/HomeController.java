package com.example.springdataforum.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String homePage() {
        return "index";
    }
    @GetMapping("/")
    public String homePageRedirect() {
        return "redirect:/home";
    }
    @GetMapping("/add")
    public String addPage() {
        return "addlinks";
    }
    @GetMapping("/all")
    public String allPage() {
        return "alllinks";
    }
}
