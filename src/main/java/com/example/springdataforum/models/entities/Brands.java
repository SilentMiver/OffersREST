package com.example.springdataforum.models.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "brands")
public class Brands extends BaseEntity {

    private String name;

    private LocalDateTime created;
    private LocalDateTime modified;

    public Brands(String name, LocalDateTime created, LocalDateTime modified) {
        this.name = name;
        this.created = created;
        this.modified = modified;
    }

    protected Brands() {
    }


    private List<Models> models;

    @Column(columnDefinition = "TEXT", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Column(columnDefinition = "DATE", nullable = false)

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    @Column(columnDefinition = "DATE", nullable = false)
    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }

    @OneToMany(mappedBy = "brand", cascade = CascadeType.REMOVE)
    public List<Models> getModels() {
        return models;
    }

    public void setModels(List<Models> models) {
        this.models = models;
    }
}
