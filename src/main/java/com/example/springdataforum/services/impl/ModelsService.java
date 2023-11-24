package com.example.springdataforum.services.impl;

import com.example.springdataforum.dto.BrandsDto;
import com.example.springdataforum.dto.ModelsDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ModelsService {
    ModelsDto register(ModelsDto model);

    List<ModelsDto> getAll();

    Optional<ModelsDto> get(UUID id);

    void delete(UUID id);

    ModelsDto update(ModelsDto model);
    void addModelWithValidation(ModelsDto modelsDto);
}
