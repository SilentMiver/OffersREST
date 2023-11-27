package com.example.springdataforum.models.entities;

import com.example.springdataforum.models.enums.CategoryOfVehicles;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "models")
public class Models extends BaseEntity {

    private String name;

    CategoryOfVehicles category;

    String imageURL;

    int startYear;

    int endYear;

    LocalDateTime created;

    LocalDateTime modified;
    // brand ссылка To do

    private Brands brand;

    private List<Offers> offers;

    protected Models() {
    }

    public Models(String name, CategoryOfVehicles category, String imageURL, int startYear, int endYear, LocalDateTime created, LocalDateTime modified, Brands brand) {
        this.name = name;
        this.category = category;
        this.imageURL = imageURL;
        this.startYear = startYear;
        this.endYear = endYear;
        this.created = created;
        this.modified = modified;
        this.brand = brand;
    }


    public Models(String name, CategoryOfVehicles category, String imageURL, int startYear, int endYear, LocalDateTime created, LocalDateTime modified) {
        this.name = name;
        this.category = category;
        this.imageURL = imageURL;
        this.startYear = startYear;
        this.endYear = endYear;
        this.created = created;
        this.modified = modified;
    }

    public Models(String name, CategoryOfVehicles category, String imageURL, int startYear, int endYear, LocalDateTime created, LocalDateTime modified, Brands brand, List<Offers> offers) {
        this.name = name;
        this.category = category;
        this.imageURL = imageURL;
        this.startYear = startYear;
        this.endYear = endYear;
        this.created = created;
        this.modified = modified;
        this.brand = brand;
        this.offers = offers;
    }

    @Column(nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    public CategoryOfVehicles getCategory() {
        return category;
    }

    public void setCategory(CategoryOfVehicles category) {
        this.category = category;
    }

    @Column(nullable = false)
    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    @Column(nullable = false)
    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    @Column(nullable = false)
    public int getEndYear() {
        return endYear;
    }

    public void setEndYear(int endYear) {
        this.endYear = endYear;
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

    @ManyToOne
    @JoinColumn(name = "brand_id", referencedColumnName = "id")
    public Brands getBrand() {
        return brand;
    }

    public void setBrand(Brands brands) {
        this.brand = brands;
    }
    @OneToMany(mappedBy = "model", cascade = CascadeType.REMOVE)
    public List<Offers> getOffers() {
        return offers;
    }

    public void setOffers(List<Offers> offers) {
        this.offers = offers;
    }

}
