package com.example.springdataforum.services.impl;

import com.example.springdataforum.dto.*;
import com.example.springdataforum.models.Brands;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BrandsService {
    ShowDetailedBrandsInfoDto register(ShowDetailedBrandsInfoDto brand);

    List<ShowDetailedBrandsInfoDto> getAll();

    Optional<ShowDetailedBrandsInfoDto> get(UUID id);

    void delete(UUID id);


    ShowDetailedBrandsInfoDto update(ShowDetailedBrandsInfoDto brand);
    void addBrandWithValidation(ShowDetailedBrandsInfoDto showDetailedBrandsInfoDto);
//------------------------ not Rest func------------------------

    void addBrand(AddBrandDto brandDto);

    List<ShowBrandsInfoDto> getAllBrands();
    ShowDetailedBrandsInfoDto brandDetails(String brandName) ;
    void removeBrand(String brandName);
    Optional<Brands> findByName(String name);
    void updateBrand(String name, UpdateBrandDto updateBrandDto);


}
