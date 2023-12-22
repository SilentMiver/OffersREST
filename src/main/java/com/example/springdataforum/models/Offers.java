package com.example.springdataforum.models;

import com.example.springdataforum.Constans.TypesOFTransmission;
import com.example.springdataforum.Constans.TypesOfGas;
import jakarta.persistence.*;

import java.util.Date;


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
    Date created;
    Date modified;
    // model and seller
    @ManyToOne
    @JoinColumn(name = "model_id", referencedColumnName = "id")
    private Models model;

    //seller скорее всего user
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private Users user;

    @Column(name = "description", columnDefinition = "TEXT")

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Enumerated(EnumType.STRING) // Не хочет ординал
    @Column(name = "engine")
    public TypesOfGas getEngine() {
        return engine;
    }

    public void setEngine(TypesOfGas engine) {
        this.engine = engine;
    }

    @Column(name = "imageURL")
    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    @Column(name = "mileage")

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    @Column(name = "price")


    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Column(name = "transmission")


    public TypesOFTransmission getTransmission() {
        return transmission;
    }

    public void setTransmission(TypesOFTransmission transmission) {
        this.transmission = transmission;
    }

    @Column(name = "year")

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

    public Users getUser() {
        return user;
    }

    public void setUser(Users users) {
        this.user = users;
    }

    @Column(name = "created")

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @Column(name = "modified")

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public Offers(String description, TypesOfGas engine, String imageURL, int mileage, int price, TypesOFTransmission transmission, String year, Date created, Date modified, Models model, Users user) {
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
        this.user = user;
    }

    protected Offers() {
    }
}
