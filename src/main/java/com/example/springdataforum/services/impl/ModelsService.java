package com.example.springdataforum.services.impl;

import com.example.springdataforum.Constans.CategoryOfVehicles;
import com.example.springdataforum.dto.AddModelDto;
import com.example.springdataforum.dto.ShowDetailedModelsInfoDto;
import com.example.springdataforum.dto.ShowModelsInfoDto;

import java.util.List;

public interface ModelsService {
    void addModel(AddModelDto modelDto);
    List<ShowDetailedModelsInfoDto> getAll();
    List<ShowModelsInfoDto> getAllModels();
    ShowDetailedModelsInfoDto modelDetails(String modelName) ;
    void removeModel(String modelName);
    ShowModelsInfoDto getModelByName(String name);
    List<ShowModelsInfoDto> getAllModelsByBrand(String brandName);
    List<ShowModelsInfoDto> getAllModelsByBrandAndCategory(String brandName, CategoryOfVehicles category);

    List<ShowModelsInfoDto> getAllModelsByCategory(CategoryOfVehicles category);
}

//    ShowDetailedModelsInfoDto register(ShowDetailedModelsInfoDto model);
////

////
////    Optional<ShowDetailedModelsInfoDto> get(UUID id);
////
////    void delete(UUID id);
////
////    ShowDetailedModelsInfoDto update(ShowDetailedModelsInfoDto model);
////    void addModelWithValidation(ShowDetailedModelsInfoDto showDetailedModelsInfoDto);