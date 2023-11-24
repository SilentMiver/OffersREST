package com.example.springdataforum.services.impl;

import com.example.springdataforum.dto.BrandsDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BrandsService {
    BrandsDto register(BrandsDto brand);

    List<BrandsDto> getAll();

    Optional<BrandsDto> get(UUID id);

    void delete(UUID id);

    BrandsDto update(BrandsDto brand);
    void addBrandWithValidation(BrandsDto brandsDto);


}
