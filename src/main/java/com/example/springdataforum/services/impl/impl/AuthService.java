package com.example.springdataforum.services.impl.impl;

import com.example.springdataforum.Constans.TypesOfRoles;
import com.example.springdataforum.dto.UserRegistrationDto;
import com.example.springdataforum.models.Users;
import com.example.springdataforum.repositories.UserRoleRepository;
import com.example.springdataforum.repositories.UsersRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class AuthService {

    private UsersRepository userRepository;

    private UserRoleRepository roleRepository;


    private PasswordEncoder passwordEncoder;

    public AuthService(UsersRepository userRepository, UserRoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    public void register(UserRegistrationDto registrationDTO) {
        if (!registrationDTO.getPassword().equals(registrationDTO.getConfirmPassword())) {
            throw new RuntimeException("passwords.match");
        }

        Optional<Users> byEmail = this.userRepository.findByEmail(registrationDTO.getEmail());

        if (byEmail.isPresent()) {
            throw new RuntimeException("email.used");
        }

        var userRole = roleRepository.
                findByRole(TypesOfRoles.USER).orElseThrow();

        Users user = new Users(
                registrationDTO.getUserName(),
                passwordEncoder.encode(registrationDTO.getPassword()),
                registrationDTO.getEmail()
        );

        user.setRole(userRole);
        user.setCreated(new Date());
        user.setModified(new Date());

        this.userRepository.save(user);
    }
}
