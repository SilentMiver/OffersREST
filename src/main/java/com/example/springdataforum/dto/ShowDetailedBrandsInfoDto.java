package com.example.springdataforum.dto;


import java.util.Date;
import java.util.UUID;

public class ShowDetailedBrandsInfoDto {
    public UUID id;
    public String name;
    public Date created;
    public Date modified;

    public ShowDetailedBrandsInfoDto(UUID id, String name, Date created, Date modified) {
        this.id = id;
        this.name = name;
        this.created = created;
        this.modified = modified;
    }

    protected ShowDetailedBrandsInfoDto() {};

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

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
        return "BrandDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", created=" + created +
                ", modified=" + modified +
                '}';
    }
}
