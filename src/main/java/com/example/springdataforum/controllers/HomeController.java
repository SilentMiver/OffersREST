package com.example.springdataforum.controllers;

import com.example.springdataforum.Constans.CategoryOfVehicles;
import com.example.springdataforum.dto.ShowDetailedOffersInfoDto;
import com.example.springdataforum.services.impl.BrandsService;
import com.example.springdataforum.services.impl.OffersService;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {
    OffersService offersService;
    BrandsService brandsService;

    @Autowired
    public void setBrandsService(BrandsService brandsService) {
        this.brandsService = brandsService;
    }

    @Autowired
    public void setOffersService(OffersService offersService) {
        this.offersService = offersService;
    }



    @GetMapping("/home")
    public String homePage(@RequestParam(name = "brandFilter", required = false) String brandFilter,
                           @RequestParam(name = "priceFilter", required = false) String priceFilter,


                           Model model) {
        List<ShowDetailedOffersInfoDto> offers;
        if (StringUtils.isNotBlank(brandFilter) && StringUtils.isNotBlank(priceFilter)) {
            offers = offersService.finaAllByBrandNameAndPrice(brandFilter, Integer.parseInt(priceFilter));
        } else if (StringUtils.isNotBlank(brandFilter)) {
            offers = offersService.finaAllByBrandName(brandFilter);
        } else if (StringUtils.isNotBlank(priceFilter)) {
            offers = offersService.finaAllByPrice(Integer.parseInt(priceFilter));
        } else {
            offers = offersService.getAll();
        }
        model.addAttribute("allOffers", offers);
        model.addAttribute("allBrands", brandsService.getAll());
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
