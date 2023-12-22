package com.example.springdataforum.dto;

import com.example.springdataforum.Constans.CategoryOfVehicles;
import com.example.springdataforum.conf.UniqueModelName;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Date;


public class AddModelDto {
    @UniqueModelName
    String name;
    CategoryOfVehicles category;
    String imageURL;
    int startYear;
    int endYear;
    Date created;
    Date modified;
    String brandId;


    public AddModelDto() {
    }
    @NotNull(message = "Brand must not be null or empty!")
    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    //    public ShowDetailedBrandsInfoDto getBrand() {
//        return brand;
//    }
//
//    public void setBrand(ShowDetailedBrandsInfoDto brand) {
//        this.brand = brand;
//    }

//    @NotEmpty(message = "Model name must not be null or empty!")
//    @Size(min = 2, max = 10, message = "Brand name must be between 2 and 10 characters!")

    @NotEmpty(message = "Model name must not be null or empty!")
    @Size(min = 2, max = 10, message = "Model name must be between 2 and 10 characters!")

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotNull(message = "Category must not be null or empty!")
    public CategoryOfVehicles getCategory() {
        return category;
    }

    public void setCategory(CategoryOfVehicles category) {
        this.category = category;
    }

    @NotEmpty(message = "URL must not be null or empty!")
    @Size(min = 2, max = 10, message = "URL must be between 2 and 10 characters!")

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    @Min(value = 1800, message = "Year must be a positive number and more than 1800!")

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    @Min(value = 1800, message = "Year must be a positive number and more than 1800!")
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
}
