package com.example.springdataforum.services.impl;

import com.example.springdataforum.dto.OffersDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OffersService {
    OffersDto register(OffersDto offer);

    List<OffersDto> getAll();

    Optional<OffersDto> get(UUID id);

    void delete(UUID id);

    OffersDto update(OffersDto offer);
    void addOfferWithValidation(OffersDto offersDto);
}
