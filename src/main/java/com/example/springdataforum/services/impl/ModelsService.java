package com.example.springdataforum.services.impl;

import com.example.springdataforum.dto.AddModelDto;
import com.example.springdataforum.dto.ShowModelsInfoDto;
import com.example.springdataforum.dto.ShowDetailedModelsInfoDto;
import com.example.springdataforum.dto.ShowDetailedModelsInfoDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ModelsService {
    void addModel(AddModelDto modelDto);

    List<ShowModelsInfoDto> getAllModels();
    ShowDetailedModelsInfoDto modelDetails(String modelName) ;
    void removeModel(String modelName);  
}
//    ShowDetailedModelsInfoDto register(ShowDetailedModelsInfoDto model);
////
////    List<ShowDetailedModelsInfoDto> getAll();
////
////    Optional<ShowDetailedModelsInfoDto> get(UUID id);
////
////    void delete(UUID id);
////
////    ShowDetailedModelsInfoDto update(ShowDetailedModelsInfoDto model);
////    void addModelWithValidation(ShowDetailedModelsInfoDto showDetailedModelsInfoDto);