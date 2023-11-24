package com.example.springdataforum.repositories;

import com.example.springdataforum.models.entities.Models;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ModelsRepository extends JpaRepository<Models, UUID> {
}
