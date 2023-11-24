package com.example.springdataforum.services.impl.impl;

import com.example.springdataforum.utils.validation.ValidationUtil;
import com.example.springdataforum.web.controllers.exceptions.ModelsIsExistException;
import com.example.springdataforum.web.controllers.exceptions.ModelsNotFoundException;
import com.example.springdataforum.dto.ModelsDto;
import com.example.springdataforum.models.entities.Models;
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
    public ModelsDto register(ModelsDto model) {
        Models b = modelMapper.map(model, Models.class);
        if (!(modelRepository.existsById(b.getId())) || get(b.getId()).isEmpty()) {
            return modelMapper.map(modelRepository.save(b), ModelsDto.class);
        } else {
            throw new ModelsIsExistException("A model with this id already exists");
        }
    }

    @Override
    public List<ModelsDto> getAll() {
        return modelRepository.findAll().stream().map((s) -> modelMapper.map(s, ModelsDto.class)).collect(Collectors.toList());
    }

    @Override
    public Optional<ModelsDto> get(UUID id) {
        return Optional.ofNullable(modelMapper.map(modelRepository.findById(id), ModelsDto.class));
    }

    @Override
    public void delete(UUID id) {
        if (modelRepository.findById(id).isPresent()) {
            modelRepository.deleteById(id);
        } else {
            throw new ModelsNotFoundException(id);
        }
    }

    @Override
    public ModelsDto update(ModelsDto model) {
        if (modelRepository.findById(model.getId()).isPresent()) {
            return modelMapper.map(modelRepository.save(modelMapper.map(model, Models.class)), ModelsDto.class);
        } else {
            throw new ModelsNotFoundException(model.getId());
        }
    }

    @Override
    public void addModelWithValidation(ModelsDto modelsDto) {
        if (!this.validationUtil.isValid(modelsDto)) {

            this.validationUtil
                    .violations(modelsDto)
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);

            throw new IllegalArgumentException("Illegal arguments!");
        }

        Models model = this.modelMapper.map(modelsDto, Models.class);
        // CHeck

        this.modelRepository.saveAndFlush(model);
    }
}