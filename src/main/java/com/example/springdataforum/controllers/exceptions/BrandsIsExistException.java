package com.example.springdataforum.controllers.exceptions;

public class BrandsIsExistException extends RuntimeException {
    public BrandsIsExistException(String message) {
        super(message);
    }
}
