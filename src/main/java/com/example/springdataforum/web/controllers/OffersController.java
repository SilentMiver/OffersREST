package com.example.springdataforum.web.controllers;

import com.example.springdataforum.dto.OffersDto;
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
    Iterable<OffersDto> all() {
        return offersService.getAll();
    }
    @GetMapping("/{id}")
    OffersDto get(@PathVariable UUID id) {
        return offersService.get(id).get();
    }
    @DeleteMapping("/{id}")
    void deleteBrand(@PathVariable UUID id) {
        offersService.delete(id);
    }
    @PostMapping()
    OffersDto update(@RequestBody OffersDto offersDto) {
        return offersService.update(offersDto);
    }
}
