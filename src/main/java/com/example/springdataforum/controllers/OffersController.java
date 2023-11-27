package com.example.springdataforum.controllers;

import com.example.springdataforum.dto.ShowDetailedOffersInfoDto;
import com.example.springdataforum.services.impl.OffersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/offers")
public class OffersController {
    // add setter injection
    private  OffersService offersService;

    @Autowired
    public void setOffersService(OffersService offersService) {
        this.offersService = offersService;
    }
    @GetMapping()
    Iterable<ShowDetailedOffersInfoDto> all() {
        return offersService.getAll();
    }
    @GetMapping("/{id}")
    ShowDetailedOffersInfoDto get(@PathVariable UUID id) {
        return offersService.get(id).get();
    }
    @DeleteMapping("/{id}")
    void deleteBrand(@PathVariable UUID id) {
        offersService.delete(id);
    }
    @PostMapping()
    ShowDetailedOffersInfoDto update(@RequestBody ShowDetailedOffersInfoDto showDetailedOffersInfoDto) {
        return offersService.update(showDetailedOffersInfoDto);
    }
}
