package com.example.springdataforum.dto;

import com.example.springdataforum.conf.UniqueUserName;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


import java.util.Date;
import java.util.UUID;

public class AddUsersDto {

    private String roleId;
    @UniqueUserName
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private boolean isActive = true;
    private String imageURL;
    private Date created;
    private Date modified;

    @NotNull(message = "Null")
    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    //    public ShowDetailedUserRolesInfoDto getRole() {
//        return role;
//    }
//
//
//    public void setRole(ShowDetailedUserRolesInfoDto role) {
//        this.role = role;
//    }
    @NotEmpty(message = "Username must not be null or empty!")
    @Size(min = 2, max = 10, message = "Brand name must be between 2 and 10 characters!")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    @NotEmpty(message = "Password must not be null or empty!")
    @Size(min = 2, max = 10, message = "Brand name must be between 2 and 10 characters!")

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @NotEmpty(message = "First name must not be null or empty!")
    @Size(min = 2, max = 10, message = "Brand name must be between 2 and 10 characters!")

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    @NotEmpty(message = "Last name must not be null or empty!")
    @Size(min = 2, max = 10, message = "Brand name must be between 2 and 10 characters!")

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @NotNull(message = "null")
    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
    @NotEmpty(message = "Image link name must not be null or empty!")
    @Size(min = 2, max = 10, message = "Brand name must be between 2 and 10 characters!")
    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }


}


