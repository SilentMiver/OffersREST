package com.example.springdataforum.controllers.exceptions;

import java.util.UUID;

public class UsersNotFoundException extends RuntimeException {
    public UsersNotFoundException(UUID id) {
        super("Could not find user " + id);
    }
    public UsersNotFoundException(String name) {
        super("Could not find user " + name);
    }
}
