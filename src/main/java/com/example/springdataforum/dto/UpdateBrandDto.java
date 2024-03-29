package com.example.springdataforum.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class UpdateBrandDto {
    @NotEmpty(message = "Brand name must not be null or empty!")
    @Size(min = 2, max = 10, message = "Brand name must be more 2 !")
    private String name;
    public String getName() {return name;}

    public void setName(String name) {this.name = name;}
}