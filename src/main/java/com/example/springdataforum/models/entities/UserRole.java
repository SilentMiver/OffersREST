package com.example.springdataforum.models.entities;

import com.example.springdataforum.models.enums.TypesOfRoles;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "roles")
public class UserRole extends BaseEntity {

    TypesOfRoles role;

    private List<Users> users;

    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    public TypesOfRoles getRole() {
        return role;
    }

    public void setRole(TypesOfRoles role) {
        this.role = role;
    }

    @OneToMany(mappedBy = "role", cascade = CascadeType.REMOVE)
    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }
}
