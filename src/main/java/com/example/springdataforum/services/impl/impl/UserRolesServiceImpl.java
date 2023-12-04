package com.example.springdataforum.services.impl.impl;

import com.example.springdataforum.Constans.TypesOfRoles;
import com.example.springdataforum.conf.utilities.ValidationUtil;
import com.example.springdataforum.controllers.exceptions.UserRolesIsExistException;
import com.example.springdataforum.controllers.exceptions.UserRolesNotFoundException;
import com.example.springdataforum.dto.*;
import com.example.springdataforum.models.Brands;
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
    public void addUserRole(AddUserRoleDto userRoleDto) {
        roleRepository.saveAndFlush(modelMapper.map(userRoleDto, UserRole.class));
    }

    @Override
    public List<ShowUserRolesInfoDto> getAllUserRoles() {
        return roleRepository.findAll().stream().map(company -> modelMapper.map(company, ShowUserRolesInfoDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ShowDetailedUserRolesInfoDto userRoleDetails(String roleNumber) {
        return modelMapper.map(roleRepository.findById(UUID.fromString(roleNumber)).orElse(null), ShowDetailedUserRolesInfoDto.class);
    }

    @Override
    public void removeUserRole(String roleName) {
        roleRepository.deleteByRole(TypesOfRoles.valueOf(roleName));
    }

    @Override
    public List<ShowDetailedUserRolesInfoDto> getAll() {
        return  roleRepository.findAll().stream().map((s) -> modelMapper.map(s, ShowDetailedUserRolesInfoDto.class)).collect(Collectors.toList());
    }


//    @Override
//    public ShowDetailedUserRolesInfoDto register(ShowDetailedUserRolesInfoDto role) {
//        UserRole b = modelMapper.map(role, UserRole.class);
//        if (!(roleRepository.existsById(b.getId())) || get(b.getId()).isEmpty()) {
//            return modelMapper.map(roleRepository.save(b), ShowDetailedUserRolesInfoDto.class);
//        } else {
//            throw new UserRolesIsExistException("A role with this id already exists");
//        }
//    }
//
//    @Override
//    public List<ShowDetailedUserRolesInfoDto> getAll() {
//        return roleRepository.findAll().stream().map((s) -> modelMapper.map(s, ShowDetailedUserRolesInfoDto.class)).collect(Collectors.toList());
//    }
//
//    @Override
//    public Optional<ShowDetailedUserRolesInfoDto> get(UUID id) {
//        return Optional.ofNullable(modelMapper.map(roleRepository.findById(id), ShowDetailedUserRolesInfoDto.class));
//    }
//
//    @Override
//    public void delete(UUID id) {
//        if (roleRepository.findById(id).isPresent()) {
//            roleRepository.deleteById(id);
//        } else {
//            throw new UserRolesNotFoundException(id);
//        }
//    }
//
//    @Override
//    public ShowDetailedUserRolesInfoDto update(ShowDetailedUserRolesInfoDto role) {
//
//    }
//
//    @Override
//    public void addUserRolesWithValidation(ShowDetailedUserRolesInfoDto showDetailedUserRolesInfoDto) {
//        if (!this.validationUtil.isValid(showDetailedUserRolesInfoDto)) {
//
//            this.validationUtil
//                    .violations(showDetailedUserRolesInfoDto)
//                    .stream()
//                    .map(ConstraintViolation::getMessage)
//                    .forEach(System.out::println);
//        } else {
//            this.roleRepository
//                    .saveAndFlush(this.modelMapper
//                            .map(showDetailedUserRolesInfoDto, UserRole.class));
//
//        }
//    }
}
