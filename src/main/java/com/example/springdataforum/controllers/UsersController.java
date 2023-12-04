package com.example.springdataforum.controllers;


import com.example.springdataforum.dto.AddUsersDto;
import com.example.springdataforum.services.impl.UserRolesService;
import com.example.springdataforum.services.impl.UsersService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/users")
public class UsersController {
    // add setter injection
    private UsersService usersService;
    private UserRolesService userRolesService;

    @Autowired
    public void setUsersService(UsersService usersService) {
        this.usersService = usersService;
    }
 @Autowired
    public void setUsersRolesService(UserRolesService userRolesService) {
        this.userRolesService = userRolesService;
    }
//    @GetMapping()
//    Iterable<ShowDetailedUsersInfoDto> all() {
//        return usersService.getAll();
//    }
//    @GetMapping("/{id}")
//    ShowDetailedUsersInfoDto get(@PathVariable UUID id) {
//        return usersService.get(id).get();
//    }
//    @DeleteMapping("/{id}")
//    void deleteUser(@PathVariable UUID id) {
//        usersService.delete(id);
//    }
//    @PostMapping()
//    ShowDetailedUsersInfoDto update(@RequestBody ShowDetailedUsersInfoDto showsDetailedUsersInfoDto) {
//        return usersService.update(showsDetailedUsersInfoDto);
//    }
@GetMapping("/all")
public String showAllUsers(Model model) {
    model.addAttribute("usersInfos", usersService.getAll());

    return "getAllUsers";
}
    @ModelAttribute("userModel")
    public AddUsersDto initUser(){
        return new AddUsersDto();
    }
    @GetMapping("/add")
    public String addUsers(Model model) {
        model.addAttribute("allRoles", userRolesService.getAll());

        return "addUsers";
    }
    @PostMapping("/add")
    public String addUsers(@Valid AddUsersDto userModel, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userModel", userModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userModel",
                    bindingResult);
            return "redirect:/users/add";
        }
        userModel.setCreated(LocalDateTime.now());
        userModel.setModified(LocalDateTime.now());
        usersService.addUser(userModel);

        return "redirect:/";
    }
    @GetMapping("/details/{userName}")
    public String userDetails(@PathVariable("userName") String userName, Model model) {
        model.addAttribute("userDetails", usersService.userDetails(userName));

        return "getUsersDetails";
    }
    @GetMapping("/remove/{userName}")
    public String deleteUser(@PathVariable("userName") String userName) {
        usersService.removeUser(userName);

        return "redirect:/users/all";
    }
}
