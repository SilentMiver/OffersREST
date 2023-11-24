package com.example.springdataforum.services.impl;

import com.example.springdataforum.dto.UserRolesDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRolesService {
    UserRolesDto register(UserRolesDto role);

    List<UserRolesDto> getAll();

    Optional<UserRolesDto> get(UUID id);

    void delete(UUID id);

    UserRolesDto update(UserRolesDto role);
    void addUserRolesWithValidation(UserRolesDto userRolesDto);
}
