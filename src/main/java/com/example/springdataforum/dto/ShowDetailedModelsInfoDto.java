package com.example.springdataforum.dto;

import com.example.springdataforum.Constans.CategoryOfVehicles;


import java.util.Date;
import java.util.UUID;

public class ShowDetailedModelsInfoDto {
    UUID id;
    String name;
    CategoryOfVehicles category;
    String imageURL;
    int startYear;
    int endYear;
    Date created;
    Date modified;
    ShowDetailedBrandsInfoDto brand;

    public ShowDetailedModelsInfoDto(UUID id, String name, CategoryOfVehicles category, String imageURL, int startYear, int endYear, Date created, Date modified, ShowDetailedBrandsInfoDto brand) {
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

    protected ShowDetailedModelsInfoDto() {};

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public ShowDetailedBrandsInfoDto getBrand() {
        return brand;
    }

    public void setBrand(ShowDetailedBrandsInfoDto brand) {
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

    @Override
    public String toString() {
        return "ShowDetailedModelsInfoDto{" +
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
