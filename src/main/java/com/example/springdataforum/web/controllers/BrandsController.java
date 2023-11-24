package com.example.springdataforum.web.controllers;

import com.example.springdataforum.dto.BrandsDto;
import com.example.springdataforum.services.impl.BrandsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/brands")
public class BrandsController {
    //Add setter injection
    private BrandsService brandService;

    @Autowired
    public void setBrandService(BrandsService brandService) {
        this.brandService = brandService;
    }


    @GetMapping()
    Iterable<BrandsDto> all() {
        return brandService.getAll();
    }

    @GetMapping("/{id}")
    BrandsDto get(@PathVariable UUID id) {
        return brandService.get(id).get();
    }

    @DeleteMapping("/{id}")
    void deleteBrand(@PathVariable UUID id) {
        brandService.delete(id);
    }

    @PostMapping()
    BrandsDto update(@RequestBody BrandsDto brand) {
        return brandService.update(brand);
    }
}
