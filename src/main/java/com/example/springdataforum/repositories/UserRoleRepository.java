package com.example.springdataforum.repositories;

import com.example.springdataforum.models.entities.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRoleRepository extends JpaRepository<UserRole, UUID> {
}
