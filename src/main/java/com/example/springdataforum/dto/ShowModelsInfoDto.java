package com.example.springdataforum.dto;


import com.example.springdataforum.Constans.CategoryOfVehicles;

public class ShowModelsInfoDto {
    private String name;
    private CategoryOfVehicles category;

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
}

