package com.example.springdataforum.controllers;


import com.example.springdataforum.dto.AddUsersDto;
import com.example.springdataforum.dto.UpdateUserDto;
import com.example.springdataforum.dto.UserRegistrationDto;
import com.example.springdataforum.models.Users;
import com.example.springdataforum.repositories.UsersRepository;
import com.example.springdataforum.services.impl.UserRolesService;
import com.example.springdataforum.services.impl.UsersService;
import com.example.springdataforum.services.impl.impl.AuthService;
import com.example.springdataforum.view.UserProfileView;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/users")
public class UsersController {
    // add setter injection
    private UsersService usersService;
    private UserRolesService userRolesService;
    private UsersRepository usersRepository;
    private AuthService authService;

    @Autowired
    public void setAuthService(AuthService authService) {
        this.authService = authService;
    }

    @Autowired
    public void setUsersRepository(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

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
    public AddUsersDto initUser() {
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

        return "redirect:/users/all";
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

    @GetMapping("/update/{user-userName}")
    public String updateUserForm(@PathVariable("user-userName") String userName, Model model) {
        Users user = usersRepository.findByUsername(userName).orElse(null);
        model.addAttribute("user", user);
        model.addAttribute("updateUserModel", new UpdateUserDto());
        return "/user-update";
    }

    @PostMapping("/update/{user-userName}")
    public String updateUser(@PathVariable("user-userName") String userName, @Valid UpdateUserDto updateUserDto,
                             BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("updateUserModel", updateUserDto);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.updateUserModel",
                    bindingResult);
            return "redirect:/users/update/" + userName;
        }
        usersService.updateUser(userName, updateUserDto);
        return "redirect:/users/all";
    }

    @GetMapping("/register")
    public String addUser(Model model) {
        return "register";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @ModelAttribute("userRegistrationDto")
    public UserRegistrationDto initForm() {
        return new UserRegistrationDto();
    }

    @PostMapping("/register")
    public String createUser(@Valid UserRegistrationDto userRegistrationDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userRegistrationDto", userRegistrationDto);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegistrationDto", bindingResult);
            return "redirect:/users/register";
        }
        authService.register(userRegistrationDto);

        return "redirect:/users/login";
    }

    @PostMapping("/login-error")
    public String onFailedLogin(
            @ModelAttribute(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY) String userName,
            RedirectAttributes redirectAttributes) {

        redirectAttributes.addFlashAttribute(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY, userName);
        redirectAttributes.addFlashAttribute("badCredentials", true);
        System.out.println(usersService.getUser(userName));
        return "redirect:/users/login";
    }

    @GetMapping("/profile")
    public String profile(Principal principal, Model model) {
        String username = principal.getName();
        Users user = usersService.getUser(username);

        UserProfileView userProfileView = new UserProfileView(
                user.getUsername(),
                user.getEmail()
        );

        model.addAttribute("user", userProfileView);

        return "profile";
    }


}