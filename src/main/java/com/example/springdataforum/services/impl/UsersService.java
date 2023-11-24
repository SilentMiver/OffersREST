package com.example.springdataforum.services.impl;

import com.example.springdataforum.dto.UsersDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UsersService {
    UsersDto register(UsersDto users);

    List<UsersDto> getAll();

    Optional<UsersDto> get(UUID id);

    void delete(UUID id);

    UsersDto update(UsersDto users);
    void addUserWithValidation(UsersDto usersDto);
}
