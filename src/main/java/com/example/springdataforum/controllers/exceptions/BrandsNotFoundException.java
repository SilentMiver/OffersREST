package com.example.springdataforum.controllers.exceptions;

import java.util.UUID;

public class BrandsNotFoundException extends RuntimeException{
    public BrandsNotFoundException(UUID id) {
        super("Could not find brand " + id);
    }
}
