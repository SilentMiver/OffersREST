package com.example.springdataforum.dto;


import com.example.springdataforum.Constans.CategoryOfVehicles;

import java.util.UUID;

public class ShowModelsInfoDto {
//    UUID id;
    String name;
    CategoryOfVehicles category;



    CategoryOfVehicles getCategory() {
        return category;
    }

    void setCategory(CategoryOfVehicles category) {
        this.category = category;
    }

//    public UUID getId() {
//        return id;
//    }
//
//    public void setId(UUID id) {
//        this.id = id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

