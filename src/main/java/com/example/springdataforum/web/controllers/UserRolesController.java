package com.example.springdataforum.web.controllers;



import com.example.springdataforum.dto.UserRolesDto;
import com.example.springdataforum.services.impl.UserRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/userRoles")
public class UserRolesController {
    // add setter injection
    private UserRolesService userRolesService;

    @Autowired
    public void setUserRolesService(UserRolesService userRolesService) {
        this.userRolesService = userRolesService;
    }
    @GetMapping()
    Iterable<UserRolesDto> all() {
        return userRolesService.getAll();
    }
    @GetMapping("/{id}")
    UserRolesDto get(@PathVariable UUID id) {
        return userRolesService.get(id).get();
    }
    @DeleteMapping("/{id}")
    void deleteBrand(@PathVariable UUID id) {
        userRolesService.delete(id);
    }
    @PostMapping()
    UserRolesDto update(@RequestBody UserRolesDto userRolesDto) {
        return userRolesService.update(userRolesDto);
    }
}

