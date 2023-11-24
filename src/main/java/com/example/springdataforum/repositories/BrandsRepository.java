package com.example.springdataforum.repositories;

import com.example.springdataforum.models.entities.Brands;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BrandsRepository extends JpaRepository<Brands, UUID> {
}
