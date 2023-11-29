package com.example.springdataforum.controllers;

import com.example.springdataforum.dto.AddBrandDto;
import com.example.springdataforum.services.impl.BrandsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller //not @Rest
@RequestMapping("/brands")
public class BrandsController {
    //Add setter injection
    private BrandsService brandService;

    @Autowired
    public void setBrandService(BrandsService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("/all")
    public String showAllBrands(Model model) {
        model.addAttribute("brandsInfos", brandService.getAll());

        return "getAllBrands";
    }
    @ModelAttribute("brandModel")
    public AddBrandDto initBrand(){
        return new AddBrandDto();
    }
    @GetMapping("/add")
    public String addBrands() {
        return "addBrands";
    }
    @PostMapping("/add")
    public String addBrands(@Valid AddBrandDto brandModel, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("brandModel", brandModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.brandModel",
                    bindingResult);
            return "redirect:/brands/add";
        }
        brandService.addBrand(brandModel);

        return "redirect:/brands/all";
    }
    @GetMapping("/brand-details/{brand-name}")
    public String brandDetails(@PathVariable("brand-name") String brandName, Model model) {
        model.addAttribute("brandDetails", brandService.brandDetails(brandName));

        return "getBrandDetails";
    }
    @GetMapping("/brand-delete/{brand-name}")
    public String deleteBrand(@PathVariable("brand-name") String brandName) {
        brandService.removeBrand(brandName);

        return "redirect:/brands/all";
    }



}

