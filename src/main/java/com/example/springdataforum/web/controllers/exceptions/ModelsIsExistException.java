package com.example.springdataforum.web.controllers.exceptions;

public class ModelsIsExistException extends RuntimeException {
    public ModelsIsExistException(String message) {
        super(message);
    }
}
