package com.example.springdataforum.repositories;

import com.example.springdataforum.models.entities.Offers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OffersRepository extends JpaRepository<Offers, UUID> {
}
