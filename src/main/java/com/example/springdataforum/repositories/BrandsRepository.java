package com.example.springdataforum.repositories;

import com.example.springdataforum.models.Brands;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

public interface BrandsRepository extends JpaRepository<Brands, UUID> {
    Optional<Brands> findByName(String name);
    @Modifying
    @Transactional
    void deleteByName(String name);
}
