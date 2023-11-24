package com.example.springdataforum.web.controllers.exceptions;

public class BrandsIsExistException extends RuntimeException {
    public BrandsIsExistException(String message) {
        super(message);
    }
}
