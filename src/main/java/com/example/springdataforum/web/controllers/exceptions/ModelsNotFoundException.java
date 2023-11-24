package com.example.springdataforum.web.controllers.exceptions;

import java.util.UUID;

public class ModelsNotFoundException extends RuntimeException {
    public ModelsNotFoundException(UUID id) {
        super("Could not find model " + id);
    }
}
