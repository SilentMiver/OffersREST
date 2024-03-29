package com.example.springdataforum.dto;

import com.example.springdataforum.Constans.TypesOFTransmission;
import com.example.springdataforum.Constans.TypesOfGas;


import java.util.Date;
import java.util.UUID;

public class ShowDetailedOffersInfoDto {
    UUID id;

    String description;
    TypesOfGas engine;
    String imageURL;
    int mileage;
    int price;
    TypesOFTransmission transmission;
    int year;
    Date created;
    Date modified;
    ShowDetailedModelsInfoDto model;
    ShowDetailedUsersInfoDto user;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public ShowDetailedModelsInfoDto getModel() {
        return model;
    }

    public void setModel(ShowDetailedModelsInfoDto model) {
        this.model = model;
    }

    public ShowDetailedUsersInfoDto getUser() {
        return user;
    }

    public void setUser(ShowDetailedUsersInfoDto user) {
        this.user = user;
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    protected ShowDetailedOffersInfoDto() {
    }

    @Override
    public String toString() {
        return description;
    }
}
