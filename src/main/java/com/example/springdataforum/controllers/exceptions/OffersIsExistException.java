package com.example.springdataforum.controllers.exceptions;

public class OffersIsExistException extends RuntimeException {
    public OffersIsExistException(String message) {
        super(message);
    }
}
