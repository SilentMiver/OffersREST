package com.example.springdataforum.dto;

import com.example.springdataforum.Constans.TypesOfGas;

import java.time.LocalDateTime;
import java.util.UUID;

public class ShowOffersInfoDto {
    private UUID id;
    private String description;
    private TypesOfGas engine;
    private int price;
    private LocalDateTime created;
    private LocalDateTime modified;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TypesOfGas getEngine() {
        return engine;
    }

    public void setEngine(TypesOfGas engine) {
        this.engine = engine;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }
}

