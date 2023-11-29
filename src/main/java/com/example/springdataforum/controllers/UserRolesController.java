package com.example.springdataforum.controllers;



import com.example.springdataforum.dto.AddUserRoleDto;
import com.example.springdataforum.dto.ShowDetailedUserRolesInfoDto;
import com.example.springdataforum.dto.ShowUserRolesInfoDto;
import com.example.springdataforum.services.impl.UserRolesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

//@RestController
//@RequestMapping("/userRoles")
//public class UserRolesController {
    // add setter injection
//    private UserRolesService userRolesService;
//
//    @Autowired
//    public void setUserRolesService(UserRolesService userRolesService) {
//        this.userRolesService = userRolesService;
//    }
//    @GetMapping()
//    Iterable<ShowDetailedUserRolesInfoDto> all() {
//        return userRolesService.getAll();
//    }
//    @GetMapping("/{id}")
//    ShowDetailedUserRolesInfoDto get(@PathVariable UUID id) {
//        return userRolesService.get(id).get();
//    }
//    @DeleteMapping("/{id}")
//    void deleteBrand(@PathVariable UUID id) {
//        userRolesService.delete(id);
//    }
//    @PostMapping()
//    ShowDetailedUserRolesInfoDto update(@RequestBody ShowDetailedUserRolesInfoDto showDetailedUserRolesInfoDto) {
//        return userRolesService.update(showDetailedUserRolesInfoDto);
//    }
    @Controller
    @RequestMapping("/userRoles")
    public class UserRolesController {

        private UserRolesService userRolesService;

        @Autowired
        public void setUserRolesService(UserRolesService userRolesService){
            this.userRolesService = userRolesService;
        }

        @GetMapping("/add")
        public String showAddUserRoleForm(Model model) {
            model.addAttribute("addUserRoleDto", new AddUserRoleDto());
            return "addUserRole";
        }

        @PostMapping("/add")
        public String addUserRole(@ModelAttribute @Valid AddUserRoleDto userRoleDto, BindingResult bindingResult) {
            if (bindingResult.hasErrors()) {
                return "addUserRole";
            }
            userRolesService.addUserRole(userRoleDto);
            return "redirect:/userRoles/getAll";
        }

        @GetMapping("/getAll")
        public String getAllUserRoles(Model model) {
            List<ShowUserRolesInfoDto> userRoles = userRolesService.getAllUserRoles();
            model.addAttribute("userRoles", userRoles);
            return "getAllUserRoles";
        }

        @GetMapping("/details/{roleNumber}")
        public String getUserRoleDetails(@PathVariable String roleNumber, Model model) {
            ShowDetailedUserRolesInfoDto userRoleDetails = userRolesService.userRoleDetails(roleNumber);
            model.addAttribute("userRoleDetails", userRoleDetails);
            return "getUserRoleDetails";
        }

        @GetMapping("/remove/{roleName}")
        public String showRemoveUserRoleForm(@PathVariable String roleName, Model model) {
            model.addAttribute("roleName", roleName);
            return "removeUserRole";
        }

        @PostMapping("/remove")
        public String removeUserRole(@RequestParam String roleName) {
            userRolesService.removeUserRole(roleName);
            return "redirect:/userRoles/getAll";
        }
    }



