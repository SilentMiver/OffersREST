package com.example.springdataforum.controllers.exceptions;

public class ModelsIsExistException extends RuntimeException {
    public ModelsIsExistException(String message) {
        super(message);
    }
}
