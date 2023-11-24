package com.example.springdataforum.web.controllers.exceptions;

public class UserRolesIsExistException extends RuntimeException {
    public UserRolesIsExistException(String message) {
        super(message);
    }
}
