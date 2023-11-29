package com.example.springdataforum.services.impl.impl;

import com.example.springdataforum.conf.utilities.ValidationUtil;
import com.example.springdataforum.controllers.exceptions.UsersIsExistException;
import com.example.springdataforum.controllers.exceptions.UsersNotFoundException;
import com.example.springdataforum.dto.AddUsersDto;
import com.example.springdataforum.dto.ShowDetailedUsersInfoDto;
import com.example.springdataforum.dto.ShowUsersInfoDto;
import com.example.springdataforum.models.Users;
import com.example.springdataforum.repositories.UsersRepository;
import com.example.springdataforum.services.impl.UsersService;
import jakarta.validation.ConstraintViolation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UsersServiceImpl implements UsersService {

    private final ModelMapper modelMapper;
    private UsersRepository usersRepository;
    private final ValidationUtil validationUtil;

    public UsersServiceImpl(ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Autowired
    void setUsersRepository(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Deprecated
    @Override
    public ShowDetailedUsersInfoDto register(ShowDetailedUsersInfoDto users) {
        Users b = modelMapper.map(users, Users.class);
        if (!(usersRepository.existsById(b.getId())) || get(b.getId()).isEmpty()) {
            return modelMapper.map(usersRepository.save(b), ShowDetailedUsersInfoDto.class);
        } else {
            throw new UsersIsExistException("A user with this id already exists");
        }
    }

    @Deprecated
    @Override
    public List<ShowDetailedUsersInfoDto> getAll() {
        return usersRepository.findAll().stream().map((s) -> modelMapper.map(s, ShowDetailedUsersInfoDto.class)).collect(Collectors.toList());
    }

    @Deprecated
    @Override
    public Optional<ShowDetailedUsersInfoDto> get(UUID id) {
        return Optional.ofNullable(modelMapper.map(usersRepository.findById(id), ShowDetailedUsersInfoDto.class));
    }

    @Deprecated
    @Override
    public void delete(UUID id) {
        if (usersRepository.findById(id).isPresent()) {
            usersRepository.deleteById(id);
        } else {
            throw new UsersNotFoundException(id);
        }
    }

    @Deprecated
    @Override
    public ShowDetailedUsersInfoDto update(ShowDetailedUsersInfoDto users) {
        if (usersRepository.findById(users.getId()).isPresent()) {
            return modelMapper.map(usersRepository.save(modelMapper.map(users, Users.class)), ShowDetailedUsersInfoDto.class);
        } else {
            throw new UsersNotFoundException(users.getId());
        }
    }

    @Deprecated
    @Override
    public void addUserWithValidation(ShowDetailedUsersInfoDto showDetailedUsersInfoDto) {
        if (!this.validationUtil.isValid(showDetailedUsersInfoDto)) {

            this.validationUtil
                    .violations(showDetailedUsersInfoDto)
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);

            throw new IllegalArgumentException("Illegal arguments!");
        }

        Users user = this.modelMapper.map(showDetailedUsersInfoDto, Users.class);


        this.usersRepository.saveAndFlush(user);
    }

    @Override
    public void addUser(AddUsersDto userDto) {
        usersRepository.saveAndFlush(modelMapper.map(userDto, Users.class));
    }

    @Override
    public List<ShowUsersInfoDto> getAllUsers() {
        return usersRepository.findAll().stream().map(user -> modelMapper.map(user, ShowUsersInfoDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ShowDetailedUsersInfoDto userDetails(String userName) {
        return modelMapper.map(usersRepository.findByUsername(userName).orElse(null), ShowDetailedUsersInfoDto.class);
    }

    @Override
    public void removeUser(String userName) {
        usersRepository.deleteByUsername(userName);

    }
}
