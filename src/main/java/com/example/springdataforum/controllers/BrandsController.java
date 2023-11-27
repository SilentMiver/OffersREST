package com.example.springdataforum.controllers;

import com.example.springdataforum.dto.ShowDetailedBrandsInfoDto;
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
    Iterable<ShowDetailedBrandsInfoDto> all() {
        return brandService.getAll();
    }

    @GetMapping("/{id}")
    ShowDetailedBrandsInfoDto get(@PathVariable UUID id) {
        return brandService.get(id).get();
    }

    @DeleteMapping("/{id}")
    void deleteBrand(@PathVariable UUID id) {
        brandService.delete(id);
    }

    @PostMapping()
    ShowDetailedBrandsInfoDto update(@RequestBody ShowDetailedBrandsInfoDto brand) {
        return brandService.update(brand);
    }
}
