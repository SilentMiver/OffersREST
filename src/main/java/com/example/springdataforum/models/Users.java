package com.example.springdataforum.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users")
public class Users extends BaseEntity {
    @Column(name = "username")
    String username;
    @Column(name = "password")
    String password;
    @Column(name = "firstName")
    String firstName;
    @Column(name = "lastName")
    String lastName;
    //role
    @Column(name = "isactive")
    private boolean isActive;
    @Column(name = "imageURL")
    String imageURL;
    @Column(name = "created")
    LocalDateTime created;
    @Column(name = "modified")
    LocalDateTime modified;

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private UserRole role;

    @OneToMany(mappedBy = "users", cascade = CascadeType.REMOVE)
    private List<Offers> offers;

    protected Users() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
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

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole roles) {
        this.role = roles;
    }

    public List<Offers> getOffers() {
        return offers;
    }

    public void setOffers(List<Offers> offers) {
        this.offers = offers;
    }

    public Users(String username, String password, String firstName, String lastName, boolean isActive, String imageURL, LocalDateTime created, LocalDateTime modified, UserRole role, List<Offers> offers) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isActive = isActive;
        this.imageURL = imageURL;
        this.created = created;
        this.modified = modified;
        this.role = role;
        this.offers = offers;
    }
}
