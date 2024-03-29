package com.example.springdataforum.services.impl.impl;

import com.example.springdataforum.conf.utilities.ValidationUtil;
import com.example.springdataforum.controllers.exceptions.OffersIsExistException;
import com.example.springdataforum.controllers.exceptions.OffersNotFoundException;
import com.example.springdataforum.dto.*;
import com.example.springdataforum.dto.ShowDetailedOffersInfoDto;
import com.example.springdataforum.models.Offers;
import com.example.springdataforum.models.Offers;
import com.example.springdataforum.repositories.OffersRepository;
import com.example.springdataforum.services.impl.OffersService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import jakarta.validation.ConstraintViolation;

@Service
@EnableCaching
public class OffersServiceImpl implements OffersService {

    private final ModelMapper modelMapper;
    private OffersRepository offerRepository;

    @Autowired
    public void setOfferRepository(OffersRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    public OffersServiceImpl(ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.modelMapper = modelMapper;

    }



    @Override
    public void addOffer(AddOfferDto offerDto) {
        offerRepository.saveAndFlush(modelMapper.map(offerDto, Offers.class));
    }

    @Override
    public List<ShowOffersInfoDto> getAllOffers() {
        return offerRepository.findAll().stream().map(company -> modelMapper.map(company, ShowOffersInfoDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ShowDetailedOffersInfoDto offerDetails(String id) {

        return modelMapper.map(offerRepository.findById(UUID.fromString(id)).orElse(null), ShowDetailedOffersInfoDto.class);
    }
    @CacheEvict(value = "offers", allEntries = true)
    @Override
    public void removeOffer(String description) {
        offerRepository.deleteByDescription(description);

    }
    @Cacheable(value = "offers")
    @Override
    public List<ShowDetailedOffersInfoDto> getAll() {
        return offerRepository.findAll().stream().map((s) -> modelMapper.map(s, ShowDetailedOffersInfoDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<ShowDetailedOffersInfoDto> findAllByUserName(String username) {
        return offerRepository.findAllByUserName(username).stream().map((s) -> modelMapper.map(s, ShowDetailedOffersInfoDto.class)).collect(Collectors.toList());
    }
@Override
public List<ShowDetailedOffersInfoDto> finaAllByBrandName(String brandName) {
        return offerRepository.findAllByBrandName(brandName).stream().map(o -> modelMapper.map(o, ShowDetailedOffersInfoDto.class)).collect(Collectors.toList());
    }
    @Override
    public List<ShowDetailedOffersInfoDto> finaAllByBrandNameAndPrice(String brandName, int price) {
        return offerRepository.findAllByBrandNameAndPrice(brandName, price).stream().map(o -> modelMapper.map(o, ShowDetailedOffersInfoDto.class)).collect(Collectors.toList());
    }
    @Override
    public List<ShowDetailedOffersInfoDto> finaAllByPrice(int price) {
        return offerRepository.findAllByPrice(price).stream().map(o -> modelMapper.map(o, ShowDetailedOffersInfoDto.class)).collect(Collectors.toList());
    }

}

//    @Override
////    public ShowDetailedOffersInfoDto register(ShowDetailedOffersInfoDto offer) {
////        Offers b = modelMapper.map(offer, Offers.class);
////        if (!(offerRepository.existsById(b.getId())) || get(b.getId()).isEmpty())  // пиздец. найти как упростить
////        {
////
////            return modelMapper.map(offerRepository.save(b), ShowDetailedOffersInfoDto.class);
////        } else {
////            throw new OffersIsExistException("A offer with this id already exists");
////        }
////    }
////
////    @Override
////    public List<ShowDetailedOffersInfoDto> getAll() {
////        return offerRepository.findAll().stream().map((s) -> modelMapper.map(s, ShowDetailedOffersInfoDto.class)).collect(Collectors.toList());
////    }
////
////    @Override
////    public Optional<ShowDetailedOffersInfoDto> get(UUID id) {
////        return Optional.ofNullable(modelMapper.map(offerRepository.findById(id), ShowDetailedOffersInfoDto.class));
////    }
////
////    @Override
////    public void delete(UUID id) {
////        if (offerRepository.findById(id).isPresent()) {
////            offerRepository.deleteById(id);
////        } else {
////            throw new OffersNotFoundException(id);
////        }
////    }
////
////    @Override
////    public ShowDetailedOffersInfoDto update(ShowDetailedOffersInfoDto offer) {
////        if (offerRepository.findById(offer.getId()).isPresent()) {
////            return modelMapper.map(offerRepository.save(modelMapper.map(offer, Offers.class)), ShowDetailedOffersInfoDto.class);
////        } else {
////            throw new OffersNotFoundException(offer.getId());
////        }
////    }
////
////    @Override
////    public void addOfferWithValidation(ShowDetailedOffersInfoDto showDetailedOffersInfoDto) {
////        if (!this.validationUtil.isValid(showDetailedOffersInfoDto)) {
////
////            this.validationUtil
////                    .violations(showDetailedOffersInfoDto)
////                    .stream()
////                    .map(ConstraintViolation::getMessage)
////                    .forEach(System.out::println);
////
////            throw new IllegalArgumentException("Illegal arguments!");
////        }
////
////        Offers offer = this.modelMapper.map(showDetailedOffersInfoDto, Offers.class);
////
////
////        this.offerRepository.saveAndFlush(offer);
////    }