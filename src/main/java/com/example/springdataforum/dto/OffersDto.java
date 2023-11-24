package com.example.springdataforum.dto;

import com.example.springdataforum.Constans.TypesOFTransmission;
import com.example.springdataforum.Constans.TypesOfGas;

import java.time.LocalDateTime;
import java.util.UUID;

public class OffersDto {
    UUID id;
    String description;
    TypesOfGas engine;
    String imageURL;
    int mileage;
    int price;
    TypesOFTransmission transmission;
    int year;
    LocalDateTime created;
    LocalDateTime modified;
    ModelsDto model;
    UsersDto users;

    public OffersDto(UUID id, String description, TypesOfGas engine, String imageURL, int mileage, int price, TypesOFTransmission transmission, int year, LocalDateTime created, LocalDateTime modified, ModelsDto model, UsersDto users) {
        this.id = id;
        this.description = description;
        this.engine = engine;
        this.imageURL = imageURL;
        this.mileage = mileage;
        this.price = price;
        this.transmission = transmission;
        this.year = year;
        this.created = created;
        this.modified = modified;
        this.model = model;
        this.users = users;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public ModelsDto getModel() {
        return model;
    }

    public void setModel(ModelsDto model) {
        this.model = model;
    }

    public UsersDto getUsers() {
        return users;
    }

    public void setUsers(UsersDto users) {
        this.users = users;
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

    protected OffersDto() {
    }

    @Override
    public String toString() {
        return "OffersDto{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", engine=" + engine +
                ", imageURL='" + imageURL + '\'' +
                ", mileage=" + mileage +
                ", price=" + price +
                ", transmission=" + transmission +
                ", year=" + year +
                ", created=" + created +
                ", modified=" + modified +
                ", model=" + model +
                ", users=" + users +
                '}';
    }
}
