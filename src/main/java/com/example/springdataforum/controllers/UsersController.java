package com.example.springdataforum.controllers;



import com.example.springdataforum.controllers.exceptions.UsersNotFoundException;
import com.example.springdataforum.dto.UsersDto;
import com.example.springdataforum.services.impl.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UsersController {
    // add setter injection
    private UsersService usersService;

    @Autowired
    public void setUsersService(UsersService usersService) {
        this.usersService = usersService;
    }
    @GetMapping()
    Iterable<UsersDto> all() {
        return usersService.getAll();
    }
    @GetMapping("/{id}")
    UsersDto get(@PathVariable UUID id) {
        return usersService.get(id).get();
    }
    @DeleteMapping("/{id}")
    void deleteBrand(@PathVariable UUID id) {
        usersService.delete(id);
    }
    @PostMapping()
    UsersDto update(@RequestBody UsersDto usersDto) {
        return usersService.update(usersDto);
    }
}
