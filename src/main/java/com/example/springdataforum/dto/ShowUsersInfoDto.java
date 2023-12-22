package com.example.springdataforum.dto;

import java.io.Serializable;

public class ShowUsersInfoDto implements Serializable {
    private String userName;
    private String lastName;
    private boolean isActive;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
}
