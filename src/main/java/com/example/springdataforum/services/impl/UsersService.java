package com.example.springdataforum.services.impl;

import com.example.springdataforum.dto.AddUsersDto;
import com.example.springdataforum.dto.ShowDetailedUsersInfoDto;
import com.example.springdataforum.dto.ShowUsersInfoDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UsersService {
    ShowDetailedUsersInfoDto register(ShowDetailedUsersInfoDto users);

    List<ShowDetailedUsersInfoDto> getAll();

    Optional<ShowDetailedUsersInfoDto> get(UUID id);

    void delete(UUID id);

    ShowDetailedUsersInfoDto update(ShowDetailedUsersInfoDto users);
    void addUserWithValidation(ShowDetailedUsersInfoDto showDetailedUsersInfoDto);
    //------------------------ not Rest func------------------------
    void addUser(AddUsersDto userDto);

    List<ShowUsersInfoDto> getAllUsers();
    ShowDetailedUsersInfoDto userDetails(String userName) ;
    void removeUser(String userName);
}
