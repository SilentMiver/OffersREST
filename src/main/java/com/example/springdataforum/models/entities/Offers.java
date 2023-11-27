package com.example.springdataforum.models.entities;

import com.example.springdataforum.models.enums.TypesOFTransmission;
import com.example.springdataforum.models.enums.TypesOfGas;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Offers")
public class Offers extends BaseEntity {

    String description;

    TypesOfGas engine;

    String imageURL;

    int mileage;

    int price;

    TypesOFTransmission transmission;

    String year;

    LocalDateTime created;

    LocalDateTime modified;
    // model and seller

    private Models model;

    //seller скорее всего user

    private Users users;

    @Column(columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Enumerated(EnumType.ORDINAL)
    @Column()
    public TypesOfGas getEngine() {
        return engine;
    }

    public void setEngine(TypesOfGas engine) {
        this.engine = engine;
    }

    @Column(nullable = false)

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    @Column(nullable = false)

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    @Column(nullable = false)
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)


    public TypesOFTransmission getTransmission() {
        return transmission;
    }

    public void setTransmission(TypesOFTransmission transmission) {
        this.transmission = transmission;
    }
    @Column(nullable = false)
    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
    @ManyToOne
    @JoinColumn(name = "model_id", referencedColumnName = "id")

    public Models getModel() {
        return model;
    }

    public void setModel(Models models) {
        this.model = models;
    }
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
    @Column(nullable = false)

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    @Column(nullable = false)
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
