package com.example.springdataforum.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

public class ShowDetailedUsersInfoDto implements Serializable {
    UUID id;
    ShowDetailedUserRolesInfoDto role;
    String userName;
    String password;
    String firstName;
    String lastName;
    boolean isActive;
    String imageURL;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime created;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime modified;

   protected ShowDetailedUsersInfoDto() {
    }

    ;

    public ShowDetailedUsersInfoDto(UUID id, ShowDetailedUserRolesInfoDto role, String userName, String password, String firstName, String lastName, boolean isActive, String imageURL, LocalDateTime created, LocalDateTime modified) {
        this.id = id;
        this.role = role;
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isActive = isActive;
        this.imageURL = imageURL;
        this.created = created;
        this.modified = modified;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public ShowDetailedUserRolesInfoDto getRole() {
        return role;
    }

    public void setRole(ShowDetailedUserRolesInfoDto role) {
        this.role = role;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    @Override
    public String toString() {
        return userName;
    }
}
