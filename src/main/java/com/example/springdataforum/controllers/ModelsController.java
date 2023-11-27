package com.example.springdataforum.controllers;


import com.example.springdataforum.dto.ShowDetailedModelsInfoDto;
import com.example.springdataforum.services.impl.ModelsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/models")
public class ModelsController {
    // add setter injection
    private ModelsService modelsService;

    @Autowired
    public void setModelsService(ModelsService modelsService) {
        this.modelsService = modelsService;
    }

    @GetMapping()
    Iterable<ShowDetailedModelsInfoDto> all() {
        return modelsService.getAll();
    }

    @GetMapping("/{id}")
    ShowDetailedModelsInfoDto get(@PathVariable UUID id) {
        return modelsService.get(id).get();
    }

    @DeleteMapping("/{id}")
    void deleteBrand(@PathVariable UUID id) {
        modelsService.delete(id);
    }

    @PostMapping()
    ShowDetailedModelsInfoDto update(@RequestBody ShowDetailedModelsInfoDto showDetailedModelsInfoDto) {
        return modelsService.update(showDetailedModelsInfoDto);
    }
}
