package com.example.springdataforum.models;

import com.example.springdataforum.Constans.TypesOfRoles;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "roles")
public class UserRole extends BaseEntity{
    @Column(name = "name")
    TypesOfRoles role;
    @OneToMany(mappedBy = "role", cascade = CascadeType.REMOVE)
    private List<Users> users;

    public TypesOfRoles getRole() {
        return role;
    }

    public void setRole(TypesOfRoles role) {
        this.role = role;
    }

    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }
}
