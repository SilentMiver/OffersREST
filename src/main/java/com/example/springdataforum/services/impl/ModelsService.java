package com.example.springdataforum.services.impl;

import com.example.springdataforum.dto.ShowDetailedModelsInfoDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ModelsService {
    ShowDetailedModelsInfoDto register(ShowDetailedModelsInfoDto model);

    List<ShowDetailedModelsInfoDto> getAll();

    Optional<ShowDetailedModelsInfoDto> get(UUID id);

    void delete(UUID id);

    ShowDetailedModelsInfoDto update(ShowDetailedModelsInfoDto model);
    void addModelWithValidation(ShowDetailedModelsInfoDto showDetailedModelsInfoDto);
}
