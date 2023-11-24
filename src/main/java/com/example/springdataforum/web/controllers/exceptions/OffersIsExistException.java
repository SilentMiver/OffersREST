package com.example.springdataforum.web.controllers.exceptions;

public class OffersIsExistException extends RuntimeException {
    public OffersIsExistException(String message) {
        super(message);
    }
}
