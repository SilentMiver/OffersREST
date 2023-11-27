package com.example.springdataforum.repositories;

import com.example.springdataforum.models.Offers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface OffersRepository extends JpaRepository<Offers, UUID> {
    @Query("SELECT o from Offers o JOIN o.users u WHERE u.username = :username")
    List<Offers> findAllByUserName (String username);


}
