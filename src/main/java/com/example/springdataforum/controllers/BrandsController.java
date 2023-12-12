package com.example.springdataforum.controllers;

import com.example.springdataforum.dto.AddBrandDto;
import com.example.springdataforum.dto.UpdateBrandDto;
import com.example.springdataforum.models.Brands;
import com.example.springdataforum.repositories.BrandsRepository;
import com.example.springdataforum.services.impl.BrandsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.Optional;

@Controller //not @Rest
@RequestMapping("/brands")
public class BrandsController {
    //Add setter injection
    private BrandsService brandService;
    private BrandsRepository brandsRepository;

    @Autowired
    public void setBrandsRepository(BrandsRepository brandsRepository) {
        this.brandsRepository = brandsRepository;
    }

    @Autowired
    public void setBrandService(BrandsService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("/all")
    public String showAllBrands(Model model) {
        model.addAttribute("brands", brandService.getAllBrands());

        return "getAllBrands";
    }

    @ModelAttribute("brandModel")
    public AddBrandDto initBrand() {
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
        brandModel.setCreated(LocalDateTime.now());
        brandModel.setModified(LocalDateTime.now());
        brandService.addBrand(brandModel);

        return "redirect:/brands/all";
    }

    @GetMapping("/update/{brand-name}")
    public String updateBrandForm(@PathVariable("brand-name") String name, Model model) {
        Optional<Brands> brand = brandsRepository.findByName(name);
        model.addAttribute("brand", brand);
        model.addAttribute("updateBrandForm", new UpdateBrandDto());
        return "updateBrand";
    }

    @PostMapping("/update/{brand-name}")
    public String updateBrand(@PathVariable("brand-name") String name, @Valid UpdateBrandDto updateBrandDto,
                              BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("updateBrandDto", updateBrandDto);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.updateBrandDto",
                    bindingResult);
            return "redirect:/brands/update/" + name;
        }

        brandService.updateBrand(name, updateBrandDto);
        return "redirect:/brands/all";
    }

    @GetMapping("/details/{brand-name}")
    public String brandDetails(@PathVariable("brand-name") String brandName, Model model) {
        model.addAttribute("brandDetails", brandService.brandDetails(brandName));

        return "getBrandDetails";
    }

    @GetMapping("/remove/{brand-name}")
    public String deleteBrand(@PathVariable("brand-name") String brandName) {
        brandService.removeBrand(brandName);

        return "redirect:/brands/all";
    }


}

