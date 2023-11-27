package com.example.springdataforum.services.impl;

import com.example.springdataforum.dto.ShowDetailedUserRolesInfoDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRolesService {
    ShowDetailedUserRolesInfoDto register(ShowDetailedUserRolesInfoDto role);

    List<ShowDetailedUserRolesInfoDto> getAll();

    Optional<ShowDetailedUserRolesInfoDto> get(UUID id);

    void delete(UUID id);

    ShowDetailedUserRolesInfoDto update(ShowDetailedUserRolesInfoDto role);
    void addUserRolesWithValidation(ShowDetailedUserRolesInfoDto showDetailedUserRolesInfoDto);
}
