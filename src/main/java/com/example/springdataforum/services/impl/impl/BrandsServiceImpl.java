package com.example.springdataforum.services.impl.impl;

import com.example.springdataforum.conf.utilities.ValidationUtil;
import com.example.springdataforum.controllers.exceptions.BrandsIsExistException;
import com.example.springdataforum.controllers.exceptions.BrandsNotFoundException;
import com.example.springdataforum.dto.BrandsDto;
import com.example.springdataforum.models.Brands;
import com.example.springdataforum.repositories.BrandsRepository;
import com.example.springdataforum.services.impl.BrandsService;
import org.modelmapper.ModelMapper;
import jakarta.validation.ConstraintViolation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BrandsServiceImpl implements BrandsService {
    private BrandsRepository brandRepository;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    @Autowired
    public void setBrandRepository(BrandsRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public BrandsServiceImpl(ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public BrandsDto register(BrandsDto brand) {
        var b = modelMapper.map(brand, Brands.class);
        if ((brandRepository.findById(b.getId()).isEmpty()) || get(b.getId()).isEmpty()) {
            return modelMapper.map(brandRepository.save(b), BrandsDto.class);
        } else {
            throw new BrandsIsExistException("A brand with this id already exists");
        }
    }

    @Override
    public List<BrandsDto> getAll() {
        return brandRepository.findAll().stream().map((s) -> modelMapper.map(s, BrandsDto.class)).collect(Collectors.toList());
    }

    @Override
    public Optional<BrandsDto> get(UUID id) {
        return Optional.ofNullable(modelMapper.map(brandRepository.findById(id), BrandsDto.class));
    }

    @Override
    public void delete(UUID id) {
        if (brandRepository.findById(id).isPresent()) {
            brandRepository.deleteById(id);
        } else {
            throw new BrandsNotFoundException(id);
        }
    }

    @Override
    public BrandsDto update(BrandsDto brand) {
        if (brandRepository.findById(brand.getId()).isPresent()) {
            return modelMapper.map(brandRepository.save(modelMapper.map(brand, Brands.class)), BrandsDto.class);
        } else {
            throw new BrandsNotFoundException(brand.getId());
        }
    }

    @Override
    public void addBrandWithValidation(BrandsDto brandsDto) {
        if (!this.validationUtil.isValid(brandsDto)) {

            this.validationUtil
                    .violations(brandsDto)
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);

            throw new IllegalArgumentException("Illegal arguments!");
        }
        else {
            try {
                this.brandRepository
                        .saveAndFlush(this.modelMapper.map(brandsDto, Brands.class));
            } catch (Exception e) {
                System.out.println("Something went wrong! \n Validation failed!");
            }
        }
    }
}
