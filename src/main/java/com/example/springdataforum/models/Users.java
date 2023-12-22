package com.example.springdataforum.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.util.Date;
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
    private String email;
    String imageURL;

    Date created;
    Date modified;

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private UserRole role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Offers> offers;

    protected Users() {
    }
    @Column(name = "username")

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    @Column(name = "password")

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @Column(name = "firstName")

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    @Column(name = "lastName")

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    @Column(name = "isactive")

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
    @Column(name = "imageURL")

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
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
    public Users(String userName, String password, String email) {
        this();

        this.username = userName;
        this.password = password;
        this.email = email;
    }
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Users(String username, String password, String firstName, String lastName, boolean isActive, String imageURL, Date created, Date modified, UserRole role, List<Offers> offers) {
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
