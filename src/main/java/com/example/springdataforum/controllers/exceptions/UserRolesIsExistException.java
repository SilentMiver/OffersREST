package com.example.springdataforum.controllers.exceptions;

public class UserRolesIsExistException extends RuntimeException {
    public UserRolesIsExistException(String message) {
        super(message);
    }
}
