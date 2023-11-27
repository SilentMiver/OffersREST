package com.example.springdataforum.controllers;



import com.example.springdataforum.dto.ShowDetailedUserRolesInfoDto;
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
    Iterable<ShowDetailedUserRolesInfoDto> all() {
        return userRolesService.getAll();
    }
    @GetMapping("/{id}")
    ShowDetailedUserRolesInfoDto get(@PathVariable UUID id) {
        return userRolesService.get(id).get();
    }
    @DeleteMapping("/{id}")
    void deleteBrand(@PathVariable UUID id) {
        userRolesService.delete(id);
    }
    @PostMapping()
    ShowDetailedUserRolesInfoDto update(@RequestBody ShowDetailedUserRolesInfoDto showDetailedUserRolesInfoDto) {
        return userRolesService.update(showDetailedUserRolesInfoDto);
    }
}

