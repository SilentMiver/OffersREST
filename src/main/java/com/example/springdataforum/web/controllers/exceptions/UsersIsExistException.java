package com.example.springdataforum.web.controllers.exceptions;

public class UsersIsExistException extends RuntimeException {
    public UsersIsExistException(String message) {
        super(message);
    }
}
