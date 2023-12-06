package com.example.springdataforum.controllers;

import com.example.springdataforum.services.impl.OffersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {
    OffersService offersService;

    @Autowired
    public void setOffersService(OffersService offersService) {
        this.offersService = offersService;
    }


    @GetMapping("/home")
    public String homePage() {
        return "index";
    }

    @GetMapping("/allUserOffers/{userName}")
    public String allUserOffers(@PathVariable("userName") String username, Model model) {
        model.addAttribute("allUserOffers", offersService.findAllByUserName(username));
        model.addAttribute("userName", username);
        return "allUsersOffers";
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
