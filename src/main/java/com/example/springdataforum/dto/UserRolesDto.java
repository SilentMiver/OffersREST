package com.example.springdataforum.dto;

import com.example.springdataforum.Constans.TypesOfRoles;

import java.util.UUID;

public class UserRolesDto {
    UUID id;
    TypesOfRoles role;

    public UserRolesDto(UUID id, TypesOfRoles role) {
        this.id = id;
        this.role = role;

    }

    protected UserRolesDto() {
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
        return "UserRolesDto{" +
                "id=" + id +
                ", role=" + role +
                '}';
    }
}
