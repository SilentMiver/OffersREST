package com.example.springdataforum.controllers.exceptions;

public class UsersIsExistException extends RuntimeException {
    public UsersIsExistException(String message) {
        super(message);
    }
}
