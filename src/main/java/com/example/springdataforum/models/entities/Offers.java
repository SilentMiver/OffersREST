package com.example.springdataforum.models.entities;

import com.example.springdataforum.models.enums.TypesOFTransmission;
import com.example.springdataforum.models.enums.TypesOfGas;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Offers")
public class Offers extends BaseEntity {
    @Column(name = "description")
    String description;
    @Enumerated(EnumType.STRING)
    @Column(name = "engine")
    TypesOfGas engine;
    @Column(name = "imageURL")
    String imageURL;
    @Column(name = "mileage")
    int mileage;
    @Column(name = "price")
    int price;
    @Column(name = "transmission")
    TypesOFTransmission transmission;
    @Column(name = "year")
    String year;
    @Column(name = "created")
    LocalDateTime created;
    @Column(name = "modified")
    LocalDateTime modified;
    // model and seller
    @ManyToOne
    @JoinColumn(name = "model_id", referencedColumnName = "id")
    private Models model;

    //seller скорее всего user
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private Users users;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TypesOfGas getEngine() {
        return engine;
    }

    public void setEngine(TypesOfGas engine) {
        this.engine = engine;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public TypesOFTransmission getTransmission() {
        return transmission;
    }

    public void setTransmission(TypesOFTransmission transmission) {
        this.transmission = transmission;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }


    public Models getModel() {
        return model;
    }

    public void setModel(Models models) {
        this.model = models;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
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

    public Offers(String description, TypesOfGas engine, String imageURL, int mileage, int price, TypesOFTransmission transmission, String year, LocalDateTime created, LocalDateTime modified, Models model, Users users) {
        this.description = description;
        this.engine = engine;
        this.imageURL = imageURL;
        this.mileage = mileage;
        this.price = price;
        this.transmission = transmission;
        this.year = year;
        this.created = created;
        this.modified = modified;
        this.model = model;
        this.users = users;
    }

    protected Offers() {
    }
}
