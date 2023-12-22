package com.example.springdataforum.dto;

import com.example.springdataforum.Constans.TypesOFTransmission;
import com.example.springdataforum.Constans.TypesOfGas;
import com.example.springdataforum.conf.UniqueOfferDescription;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Date;


public class AddOfferDto {
    @UniqueOfferDescription
    private String description;
    private TypesOfGas engine;
    private String imageURL;
    private int mileage;
    private int price;
    private TypesOFTransmission transmission;
    private String year;
    Date created;
    Date modified;
    private String userId;
    private String modelId;
    @NotNull(message = "User must not be null or empty!")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    @NotNull(message = "Model must not be null or empty!")
    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }
    //    private ShowDetailedModelsInfoDto model;
//    private ShowDetailedUsersInfoDto user;

//    public ShowDetailedModelsInfoDto getModel() {
//        return model;
//    }
//
//    public void setModel(ShowDetailedModelsInfoDto model) {
//        this.model = model;
//    }
//
//    public ShowDetailedUsersInfoDto getUser() {
//        return user;
//    }
//
//    public void setUser(ShowDetailedUsersInfoDto user) {
//        this.user = user;
//    }

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

    @NotEmpty(message = "Model name must not be null or empty!")
    @Size(min = 10, message = "Model name must be between 10 and more characters!")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @NotNull(message = "Engine must not be null or empty!")
    public TypesOfGas getEngine() {
        return engine;
    }

    public void setEngine(TypesOfGas engine) {
        this.engine = engine;
    }
    @NotEmpty(message = "URL must not be null or empty!")
    @Size(min = 5, message = "URL must be more than 5 characters!")
    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
    @Min(value = 1, message = "Year must be a positive number")
    @NotNull(message = "null")
    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    @Min(value = 0, message = "Year must be a positive number")
    @NotNull(message = "null")
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    @NotNull(message = "Transmission must not be null or empty!")
    public TypesOFTransmission getTransmission() {
        return transmission;
    }

    public void setTransmission(TypesOFTransmission transmission) {
        this.transmission = transmission;
    }
    @Min(value = 0, message = "Year must be a positive number")
    @NotNull(message = "null")
    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }


}

