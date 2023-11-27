package com.example.springdataforum.services.impl;

import com.example.springdataforum.dto.ShowsDetailedUsersInfoDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UsersService {
    ShowsDetailedUsersInfoDto register(ShowsDetailedUsersInfoDto users);

    List<ShowsDetailedUsersInfoDto> getAll();

    Optional<ShowsDetailedUsersInfoDto> get(UUID id);

    void delete(UUID id);

    ShowsDetailedUsersInfoDto update(ShowsDetailedUsersInfoDto users);
    void addUserWithValidation(ShowsDetailedUsersInfoDto showsDetailedUsersInfoDto);
}
