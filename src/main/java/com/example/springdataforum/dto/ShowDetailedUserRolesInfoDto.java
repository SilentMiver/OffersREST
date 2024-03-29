package com.example.springdataforum.dto;

import com.example.springdataforum.Constans.TypesOfRoles;

import java.util.UUID;

public class ShowDetailedUserRolesInfoDto {
    UUID id;
    TypesOfRoles role;


    protected ShowDetailedUserRolesInfoDto() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public TypesOfRoles getRole() {
        return role;
    }

    public void setRole(TypesOfRoles role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "ShowDetailedUserRolesInfoDto{" +

                ", role=" + role +
                '}';
    }
}
