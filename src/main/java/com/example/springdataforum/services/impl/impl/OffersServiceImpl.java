package com.example.springdataforum.services.impl.impl;

import com.example.springdataforum.utils.validation.ValidationUtil;
import com.example.springdataforum.web.controllers.exceptions.OffersIsExistException;
import com.example.springdataforum.web.controllers.exceptions.OffersNotFoundException;
import com.example.springdataforum.dto.OffersDto;
import com.example.springdataforum.models.entities.Offers;
import com.example.springdataforum.repositories.OffersRepository;
import com.example.springdataforum.services.impl.OffersService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import jakarta.validation.ConstraintViolation;
@Service
public class OffersServiceImpl implements OffersService {

    private final ModelMapper modelMapper;
    private  OffersRepository offerRepository;
    private final ValidationUtil validationUtil;
    @Autowired
    public void setOfferRepository(OffersRepository offerRepository){
        this.offerRepository = offerRepository;
    }

    public OffersServiceImpl(ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }


    @Override
    public OffersDto register(OffersDto offer) {
        Offers b = modelMapper.map(offer, Offers.class);
        if (!(offerRepository.existsById(b.getId())) || get(b.getId()).isEmpty())  // пиздец. найти как упростить
        {

            return modelMapper.map(offerRepository.save(b), OffersDto.class);
        } else {
            throw new OffersIsExistException("A offer with this id already exists");
        }
    }

    @Override
    public List<OffersDto> getAll() {
        return offerRepository.findAll().stream().map((s) -> modelMapper.map(s, OffersDto.class)).collect(Collectors.toList());
    }

    @Override
    public Optional<OffersDto> get(UUID id) {
        return Optional.ofNullable(modelMapper.map(offerRepository.findById(id), OffersDto.class));
    }

    @Override
    public void delete(UUID id) {
        if (offerRepository.findById(id).isPresent()) {
            offerRepository.deleteById(id);
        } else {
            throw new OffersNotFoundException(id);
        }
    }

    @Override
    public OffersDto update(OffersDto offer) {
        if (offerRepository.findById(offer.getId()).isPresent()) {
            return modelMapper.map(offerRepository.save(modelMapper.map(offer, Offers.class)), OffersDto.class);
        } else {
            throw new OffersNotFoundException(offer.getId());
        }
    }

    @Override
    public void addOfferWithValidation(OffersDto offersDto) {
        if (!this.validationUtil.isValid(offersDto)) {

            this.validationUtil
                    .violations(offersDto)
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);

            throw new IllegalArgumentException("Illegal arguments!");
        }

        Offers offer = this.modelMapper.map(offersDto, Offers.class);


        this.offerRepository.saveAndFlush(offer);
    }
}