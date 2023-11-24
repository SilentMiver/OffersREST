package com.example.springdataforum.services.impl.impl;

import com.example.springdataforum.conf.utilities.ValidationUtil;
import com.example.springdataforum.controllers.exceptions.UserRolesIsExistException;
import com.example.springdataforum.controllers.exceptions.UserRolesNotFoundException;
import com.example.springdataforum.dto.UserRolesDto;
import com.example.springdataforum.models.UserRole;
import com.example.springdataforum.repositories.UserRoleRepository;
import com.example.springdataforum.services.impl.UserRolesService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.validation.ConstraintViolation;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserRolesServiceImpl implements UserRolesService {

    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    private UserRoleRepository roleRepository;

    public UserRolesServiceImpl(ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }
    @Autowired
    void setRoleRepository(UserRoleRepository userRoleRepository){
        this.roleRepository = userRoleRepository;
    }


    @Override
    public UserRolesDto register(UserRolesDto role) {
        UserRole b = modelMapper.map(role, UserRole.class);
        if (!(roleRepository.existsById(b.getId())) || get(b.getId()).isEmpty()) {
            return modelMapper.map(roleRepository.save(b), UserRolesDto.class);
        } else {
            throw new UserRolesIsExistException("A role with this id already exists");
        }
    }

    @Override
    public List<UserRolesDto> getAll() {
        return roleRepository.findAll().stream().map((s) -> modelMapper.map(s, UserRolesDto.class)).collect(Collectors.toList());
    }

    @Override
    public Optional<UserRolesDto> get(UUID id) {
        return Optional.ofNullable(modelMapper.map(roleRepository.findById(id), UserRolesDto.class));
    }

    @Override
    public void delete(UUID id) {
        if (roleRepository.findById(id).isPresent()) {
            roleRepository.deleteById(id);
        } else {
            throw new UserRolesNotFoundException(id);
        }
    }

    @Override
    public UserRolesDto update(UserRolesDto role) {
        if (roleRepository.findById(role.getId()).isPresent()) {
            return modelMapper.map(roleRepository.save(modelMapper.map(role, UserRole.class)), UserRolesDto.class);
        } else {
            throw new UserRolesNotFoundException(role.getId());
        }
    }

    @Override
    public void addUserRolesWithValidation(UserRolesDto userRolesDto) {
        if (!this.validationUtil.isValid(userRolesDto)) {

            this.validationUtil
                    .violations(userRolesDto)
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
        } else {
            this.roleRepository
                    .saveAndFlush(this.modelMapper
                            .map(userRolesDto, UserRole.class));

        }
    }
}
