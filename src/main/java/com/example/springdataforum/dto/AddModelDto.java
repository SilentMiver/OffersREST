package com.example.springdataforum.dto;

import com.example.springdataforum.Constans.CategoryOfVehicles;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public class AddModelDto {
    String name;
    CategoryOfVehicles category;
    String imageURL;
    int startYear;
    int endYear;
    LocalDateTime created;
    LocalDateTime modified;
    ShowDetailedBrandsInfoDto brand;


    public AddModelDto() {
    }

    public AddModelDto(String name, CategoryOfVehicles category, String imageURL, int startYear, int endYear, LocalDateTime created, LocalDateTime modified, ShowDetailedBrandsInfoDto brand) {
        this.name = name;
        this.category = category;
        this.imageURL = imageURL;
        this.startYear = startYear;
        this.endYear = endYear;
        this.created = created;
        this.modified = modified;
        this.brand = brand;
    }


    public ShowDetailedBrandsInfoDto getBrand() {
        return brand;
    }

    public void setBrand(ShowDetailedBrandsInfoDto brand) {
        this.brand = brand;
    }

    @NotEmpty(message = "Model name must not be null or empty!")
    @Size(min = 2, max = 10, message = "Brand name must be between 2 and 10 characters!")

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
}
