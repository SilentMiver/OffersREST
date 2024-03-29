package com.example.springdataforum.controllers.exceptions;

import java.util.UUID;

public class OffersNotFoundException extends RuntimeException {
    public OffersNotFoundException(UUID id) {
        super("Could not find offer " + id);
    }
}