package com.example.springdataforum.repositories;

import com.example.springdataforum.models.Offers;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface OffersRepository extends JpaRepository<Offers, UUID> {
    @Query("SELECT o from Offers o JOIN o.user u WHERE u.username = :username")
    List<Offers> findAllByUserName (String username);


    Optional<Offers> findByDescription(String description);
    @Modifying
    @Transactional
    void deleteByDescription(String description);
}
