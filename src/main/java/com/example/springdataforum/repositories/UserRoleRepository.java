package com.example.springdataforum.repositories;

import com.example.springdataforum.Constans.TypesOfRoles;
import com.example.springdataforum.models.Offers;
import com.example.springdataforum.models.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, UUID> {
    @Modifying
    @Transactional
    void deleteByRole(TypesOfRoles role);
}
