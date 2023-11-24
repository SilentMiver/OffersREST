package com.example.springdataforum.models;

import com.example.springdataforum.Constans.CategoryOfVehicles;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "models")
public class Models extends BaseEntity {
    @Column(name = "name")
    private String name;
    @Column(name = "category")
    CategoryOfVehicles category;
    @Column(name = "imageURL")
    String imageURL;
    @Column(name = "startYear")
    int startYear;
    @Column(name = "endYear")
    int endYear;
    @Column(name = "created")
    LocalDateTime created;
    @Column(name = "modified")
    LocalDateTime modified;
    // brand ссылка To do
    @ManyToOne
    @JoinColumn(name = "brand_id", referencedColumnName = "id")
    private Brands brand;
    @OneToMany(mappedBy = "model", cascade = CascadeType.REMOVE)
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

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public int getEndYear() {
        return endYear;
    }

    public void setEndYear(int endYear) {
        this.endYear = endYear;
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

    public Brands getBrand() {
        return brand;
    }

    public void setBrand(Brands brands) {
        this.brand = brands;
    }

    public List<Offers> getOffers() {
        return offers;
    }

    public void setOffers(List<Offers> offers) {
        this.offers = offers;
    }
}
