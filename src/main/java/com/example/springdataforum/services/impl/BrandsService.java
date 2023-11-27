package com.example.springdataforum.services.impl;

import com.example.springdataforum.dto.ShowDetailedBrandsInfoDto;

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


}
