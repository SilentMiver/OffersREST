package com.example.springdataforum.dto;

import com.example.springdataforum.conf.UniqueBrandName;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.Date;


public class AddBrandDto {
    @UniqueBrandName
    public String name;
    public Date created;
    public Date modified;


    @NotEmpty(message = "Brand name must not be null or empty!")
    @Size(min = 2, max = 10, message = "Brand name must be between 2 and 10 characters!")

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return "AddBrandDto{" +
                "name='" + name + '\'' +
                ", created=" + created +
                ", modified=" + modified +
                '}';
    }
}
