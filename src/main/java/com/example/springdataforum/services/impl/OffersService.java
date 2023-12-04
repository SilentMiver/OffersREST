package com.example.springdataforum.services.impl;

import com.example.springdataforum.dto.AddOfferDto;
import com.example.springdataforum.dto.ShowOffersInfoDto;
import com.example.springdataforum.dto.ShowDetailedOffersInfoDto;
import com.example.springdataforum.dto.ShowDetailedOffersInfoDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OffersService {
    void addOffer(AddOfferDto offerDto);

    List<ShowOffersInfoDto> getAllOffers();
    ShowDetailedOffersInfoDto offerDetails(String offerId) ;
    void removeOffer(String offerName);
//    ShowDetailedOffersInfoDto register(ShowDetailedOffersInfoDto offer);
//
//    List<ShowDetailedOffersInfoDto> getAll();
//
//    Optional<ShowDetailedOffersInfoDto> get(UUID id);
//
//    void delete(UUID id);
//
//    ShowDetailedOffersInfoDto update(ShowDetailedOffersInfoDto offer);
//    void addOfferWithValidation(ShowDetailedOffersInfoDto showDetailedOffersInfoDto);
}
