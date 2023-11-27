package com.example.springdataforum.models.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users")
public class Users extends BaseEntity {

    String username;

    String password;

    String firstName;

    String lastName;
    //role

    private boolean isActive;

    String imageURL;

    LocalDateTime created;

    LocalDateTime modified;

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private UserRole role;

    @OneToMany(mappedBy = "users", cascade = CascadeType.REMOVE)
    private List<Offers> offers;

    protected Users() {
    }

    @Column(nullable = false)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(nullable = false)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(nullable = false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(nullable = false)
    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Column(nullable = false)
    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
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
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole roles) {
        this.role = roles;
    }

    @OneToMany(mappedBy = "users", cascade = CascadeType.REMOVE)
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
