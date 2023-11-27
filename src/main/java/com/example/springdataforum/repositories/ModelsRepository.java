package com.example.springdataforum.repositories;

import com.example.springdataforum.models.Models;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

public interface ModelsRepository extends JpaRepository<Models, UUID> {
    @Query("SELECT m FROM Models m JOIN m.brand b WHERE b.name = :brandName")
    List<Models> findAllByBrandName(@Param("brandName") String brandName);
    @Modifying
    @Transactional
    void deleteByName(String name);
}
