package com.example.springdataforum.dto;

import com.example.springdataforum.models.enums.CategoryOfVehicles;

import java.time.LocalDateTime;
import java.util.UUID;

public class ModelsDto {
    UUID id;
    String name;
    CategoryOfVehicles category;
    String imageURL;
    int startYear;
    int endYear;
    LocalDateTime created;
    LocalDateTime modified;
    BrandsDto brand;

    public ModelsDto(UUID id, String name, CategoryOfVehicles category, String imageURL, int startYear, int endYear, LocalDateTime created, LocalDateTime modified, BrandsDto brand) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.imageURL = imageURL;
        this.startYear = startYear;
        this.endYear = endYear;
        this.created = created;
        this.modified = modified;
        this.brand = brand;
    }

    protected ModelsDto() {};

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public BrandsDto getBrand() {
        return brand;
    }

    public void setBrand(BrandsDto brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryOfVehicles getCategory() {
        return category;
    }

    public void setCategory(CategoryOfVehicles category) {
        this.category = category;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public int getEndYear() {
        return endYear;
    }

    public void setEndYear(int endYear) {
        this.endYear = endYear;
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

    @Override
    public String toString() {
        return "ModelsDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", imageURL='" + imageURL + '\'' +
                ", startYear=" + startYear +
                ", endYear=" + endYear +
                ", created=" + created +
                ", modified=" + modified +
                ", brand=" + brand +
                '}';
    }
}
