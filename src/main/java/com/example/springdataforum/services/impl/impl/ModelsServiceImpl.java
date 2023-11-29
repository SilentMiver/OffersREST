package com.example.springdataforum.services.impl.impl;

import com.example.springdataforum.conf.utilities.ValidationUtil;
import com.example.springdataforum.controllers.exceptions.ModelsIsExistException;
import com.example.springdataforum.controllers.exceptions.ModelsNotFoundException;
import com.example.springdataforum.dto.AddModelDto;
import com.example.springdataforum.dto.ShowModelsInfoDto;
import com.example.springdataforum.dto.ShowDetailedModelsInfoDto;
import com.example.springdataforum.dto.ShowDetailedModelsInfoDto;
import com.example.springdataforum.models.Models;
import com.example.springdataforum.models.Models;
import com.example.springdataforum.repositories.ModelsRepository;
import com.example.springdataforum.services.impl.ModelsService;
import org.modelmapper.ModelMapper;
import jakarta.validation.ConstraintViolation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ModelsServiceImpl implements ModelsService {

    private ModelsRepository modelRepository;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    public ModelsServiceImpl(ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }


    @Autowired
    public void setModelRepository(ModelsRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    @Override
    public void addModel(AddModelDto modelDto) {
        modelRepository.saveAndFlush(modelMapper.map(modelDto, Models.class));
    }

    @Override
    public List<ShowModelsInfoDto> getAllModels() {
        return modelRepository.findAll().stream().map(company -> modelMapper.map(company, ShowModelsInfoDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ShowDetailedModelsInfoDto modelDetails(String modelName) {
        return modelMapper.map(modelRepository.findByName(modelName).orElse(null), ShowDetailedModelsInfoDto.class);
    }

    @Override
    public void removeModel(String modelName) {
        modelRepository.deleteByName(modelName);
    }


//
}
//@Override
//    public ShowDetailedModelsInfoDto register(ShowDetailedModelsInfoDto model) {
//        Models b = modelMapper.map(model, Models.class);
//        if (!(modelRepository.existsById(b.getId())) || get(b.getId()).isEmpty()) {
//            return modelMapper.map(modelRepository.save(b), ShowDetailedModelsInfoDto.class);
//        } else {
//            throw new ModelsIsExistException("A model with this id already exists");
//        }
//    }
//
//    @Override
//    public List<ShowDetailedModelsInfoDto> getAll() {
//        return modelRepository.findAll().stream().map((s) -> modelMapper.map(s, ShowDetailedModelsInfoDto.class)).collect(Collectors.toList());
//    }
//
//    @Override
//    public Optional<ShowDetailedModelsInfoDto> get(UUID id) {
//        return Optional.ofNullable(modelMapper.map(modelRepository.findById(id), ShowDetailedModelsInfoDto.class));
//    }
//
//    @Override
//    public void delete(UUID id) {
//        if (modelRepository.findById(id).isPresent()) {
//            modelRepository.deleteById(id);
//        } else {
//            throw new ModelsNotFoundException(id);
//        }
//    }
//
//    @Override
//    public ShowDetailedModelsInfoDto update(ShowDetailedModelsInfoDto model) {
//        if (modelRepository.findById(model.getId()).isPresent()) {
//            return modelMapper.map(modelRepository.save(modelMapper.map(model, Models.class)), ShowDetailedModelsInfoDto.class);
//        } else {
//            throw new ModelsNotFoundException(model.getId());
//        }
//    }
//
//    @Override
//    public void addModelWithValidation(ShowDetailedModelsInfoDto showDetailedModelsInfoDto) {
//        if (!this.validationUtil.isValid(showDetailedModelsInfoDto)) {
//
//            this.validationUtil
//                    .violations(showDetailedModelsInfoDto)
//                    .stream()
//                    .map(ConstraintViolation::getMessage)
//                    .forEach(System.out::println);
//
//            throw new IllegalArgumentException("Illegal arguments!");
//        }
//
//        Models model = this.modelMapper.map(showDetailedModelsInfoDto, Models.class);
//        // CHeck
//
//        this.modelRepository.saveAndFlush(model);
//    }