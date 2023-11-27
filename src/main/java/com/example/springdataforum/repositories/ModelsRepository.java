package com.example.springdataforum.repositories;

import com.example.springdataforum.models.Models;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

public interface ModelsRepository extends JpaRepository<Models, UUID> {
    @Modifying
    @Transactional
    void deleteByName(String name);
}
