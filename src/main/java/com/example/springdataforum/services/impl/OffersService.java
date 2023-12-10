package com.example.springdataforum.services.impl;

import com.example.springdataforum.dto.*;
import com.example.springdataforum.dto.ShowDetailedOffersInfoDto;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OffersService {
    void addOffer(AddOfferDto offerDto);

    List<ShowOffersInfoDto> getAllOffers();

    ShowDetailedOffersInfoDto offerDetails(String offerId);

    void removeOffer(String offerName);

    List<ShowDetailedOffersInfoDto> getAll();
    List<ShowDetailedOffersInfoDto> finaAllByPrice( int price);
    List<ShowDetailedOffersInfoDto> finaAllByBrandNameAndPrice(String brandName, int price);
    List<ShowDetailedOffersInfoDto> finaAllByBrandName(String brandName);

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
    List<ShowDetailedOffersInfoDto> findAllByUserName(String username);
}
