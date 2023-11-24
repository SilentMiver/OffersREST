package com.example.springdataforum.web.controllers.exceptions;

import java.util.UUID;

public class UserRolesNotFoundException extends RuntimeException {
    public UserRolesNotFoundException(UUID id) {
        super("Could not find role " + id);
    }
}
