package com.example.springdataforum.services.impl;

import com.example.springdataforum.dto.AddUserRoleDto;
import com.example.springdataforum.dto.ShowDetailedUserRolesInfoDto;
import com.example.springdataforum.dto.ShowUserRolesInfoDto;

import java.util.List;

public interface UserRolesService {

void addUserRole(AddUserRoleDto brandDto);

    List<ShowUserRolesInfoDto> getAllUserRoles();
    ShowDetailedUserRolesInfoDto userRoleDetails(String brandName) ;
    void removeUserRole(String brandName);

    List<ShowDetailedUserRolesInfoDto> getAll();
}
//    ShowDetailedUserRolesInfoDto register(ShowDetailedUserRolesInfoDto role);
////
////    List<ShowDetailedUserRolesInfoDto> getAll();
////
////    Optional<ShowDetailedUserRolesInfoDto> get(UUID id);
////
////    void delete(UUID id);
////
////    ShowDetailedUserRolesInfoDto update(ShowDetailedUserRolesInfoDto role);
////    void addUserRolesWithValidation(ShowDetailedUserRolesInfoDto showDetailedUserRolesInfoDto);