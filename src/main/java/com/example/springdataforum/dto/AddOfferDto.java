package com.example.springdataforum.dto;

import com.example.springdataforum.Constans.TypesOFTransmission;
import com.example.springdataforum.Constans.TypesOfGas;

import java.time.LocalDateTime;
import java.util.UUID;

public class AddOfferDto {
    private String description;
    private TypesOfGas engine;
    private String imageURL;
    private int mileage;
    private int price;
    private TypesOFTransmission transmission;
    private String year;
    LocalDateTime created;
    LocalDateTime modified;
    private UUID modelId;
    private UUID userId;

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

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public TypesOFTransmission getTransmission() {
        return transmission;
    }

    public void setTransmission(TypesOFTransmission transmission) {
        this.transmission = transmission;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public UUID getModelId() {
        return modelId;
    }

    public void setModelId(UUID modelId) {
        this.modelId = modelId;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }
}

