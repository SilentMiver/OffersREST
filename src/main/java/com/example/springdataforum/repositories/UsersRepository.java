package com.example.springdataforum.repositories;

import com.example.springdataforum.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface UsersRepository extends JpaRepository<Users, UUID> {
    @Query("SELECT u FROM Users u JOIN u.role r WHERE r.role = :role")
    List<Users> findUsersByRole(@Param("role") int role);
}
