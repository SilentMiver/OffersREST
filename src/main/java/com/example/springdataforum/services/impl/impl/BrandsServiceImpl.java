package com.example.springdataforum.services.impl.impl;

import com.example.springdataforum.conf.utilities.ValidationUtil;
import com.example.springdataforum.controllers.exceptions.BrandsIsExistException;
import com.example.springdataforum.controllers.exceptions.BrandsNotFoundException;
import com.example.springdataforum.dto.*;
import com.example.springdataforum.models.Brands;
import com.example.springdataforum.repositories.BrandsRepository;
import com.example.springdataforum.services.impl.BrandsService;
import org.modelmapper.ModelMapper;
import jakarta.validation.ConstraintViolation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

    @Deprecated
    @Override
    public ShowDetailedBrandsInfoDto register(ShowDetailedBrandsInfoDto brand) {
        var b = modelMapper.map(brand, Brands.class);
        if ((brandRepository.findById(b.getId()).isEmpty()) || get(b.getId()).isEmpty()) {
            return modelMapper.map(brandRepository.save(b), ShowDetailedBrandsInfoDto.class);
        } else {
            throw new BrandsIsExistException("A brand with this id already exists");
        }
    }

    @Deprecated
    @Override
    public List<ShowDetailedBrandsInfoDto> getAll() {
        return brandRepository.findAll().stream().map((s) -> modelMapper.map(s, ShowDetailedBrandsInfoDto.class)).collect(Collectors.toList());
    }

    @Deprecated
    @Override
    public Optional<ShowDetailedBrandsInfoDto> get(UUID id) {
        return Optional.ofNullable(modelMapper.map(brandRepository.findById(id), ShowDetailedBrandsInfoDto.class));
    }

    @Deprecated
    @Override
    public void delete(UUID id) {
        if (brandRepository.findById(id).isPresent()) {
            brandRepository.deleteById(id);
        } else {
            throw new BrandsNotFoundException(id);
        }
    }


    @Deprecated
    @Override
    public ShowDetailedBrandsInfoDto update(ShowDetailedBrandsInfoDto brand) {
        if (brandRepository.findById(brand.getId()).isPresent()) {
            return modelMapper.map(brandRepository.save(modelMapper.map(brand, Brands.class)), ShowDetailedBrandsInfoDto.class);
        } else {
            throw new BrandsNotFoundException(brand.getId());
        }
    }

    @Deprecated
    @Override
    public void addBrandWithValidation(ShowDetailedBrandsInfoDto showDetailedBrandsInfoDto) {
        if (!this.validationUtil.isValid(showDetailedBrandsInfoDto)) {

            this.validationUtil
                    .violations(showDetailedBrandsInfoDto)
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);

            throw new IllegalArgumentException("Illegal arguments!");
        } else {
            try {
                this.brandRepository
                        .saveAndFlush(this.modelMapper.map(showDetailedBrandsInfoDto, Brands.class));
            } catch (Exception e) {
                System.out.println("Something went wrong! \n Validation failed!");
            }
        }
    }

    @Override
    public void addBrand(AddBrandDto brandDto) {
    brandRepository.saveAndFlush(modelMapper.map(brandDto, Brands.class));
    }

    @Override
    public List<ShowBrandsInfoDto> getAllBrands() {
        return brandRepository.findAll().stream().map(company -> modelMapper.map(company, ShowBrandsInfoDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ShowDetailedBrandsInfoDto brandDetails(String brandName) {
        return modelMapper.map(brandRepository.findByName(brandName).orElse(null), ShowDetailedBrandsInfoDto.class);
    }

    @Override
    public void removeBrand(String brandName) {
        brandRepository.deleteByName(brandName);

    }

    @Override
    public Optional<Brands> findByName(String name) {
        return brandRepository.findByName(name);
    }


    @Override
    public void updateBrand(String name, UpdateBrandDto updateBrandDto) {
        brandRepository.findByName(name).ifPresent(brand -> {
            brand.setName(updateBrandDto.getName());
            brand.setModified(LocalDateTime.now());
            brandRepository.save(brand);
        });
    }


}
