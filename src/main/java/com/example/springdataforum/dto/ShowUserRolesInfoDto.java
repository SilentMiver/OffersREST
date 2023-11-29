package com.example.springdataforum.dto;


import com.example.springdataforum.Constans.TypesOfRoles;

public class ShowUserRolesInfoDto {

    private TypesOfRoles role;

    public TypesOfRoles getRole() {
        return role;
    }

    public void setRole(TypesOfRoles role) {
        this.role = role;
    }
}

