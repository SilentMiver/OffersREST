package com.example.springdataforum.repositories;

import com.example.springdataforum.models.Brands;
import com.example.springdataforum.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface UsersRepository extends JpaRepository<Users, UUID> {
    @Query("SELECT u FROM Users u JOIN u.role r WHERE r.role = :role")
    List<Users> findUsersByRole(@Param("role") int role);
    Optional<Users> findByUsername(String username);
    Optional<Users> findByEmail(String email);
    @Modifying
    @Transactional
    void deleteByUsername(String name);
}
