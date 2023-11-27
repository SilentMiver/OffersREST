package com.example.springdataforum.services.impl.impl;

import com.example.springdataforum.conf.utilities.ValidationUtil;
import com.example.springdataforum.controllers.exceptions.UsersIsExistException;
import com.example.springdataforum.controllers.exceptions.UsersNotFoundException;
import com.example.springdataforum.dto.ShowsDetailedUsersInfoDto;
import com.example.springdataforum.models.Users;
import com.example.springdataforum.repositories.UsersRepository;
import com.example.springdataforum.services.impl.UsersService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import jakarta.validation.ConstraintViolation;
@Service
public class UsersServiceImpl implements UsersService {

    private final ModelMapper modelMapper;
    private  UsersRepository usersRepository;
    private final ValidationUtil validationUtil;

    public UsersServiceImpl(ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }
    @Autowired
    void setUsersRepository(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }

    @Override
    public ShowsDetailedUsersInfoDto register(ShowsDetailedUsersInfoDto users) {
        Users b = modelMapper.map(users, Users.class);
        if (!(usersRepository.existsById(b.getId())) || get(b.getId()).isEmpty()) {
            return modelMapper.map(usersRepository.save(b), ShowsDetailedUsersInfoDto.class);
        } else {
            throw new UsersIsExistException("A user with this id already exists");
        }
    }

    @Override
    public List<ShowsDetailedUsersInfoDto> getAll() {
        return usersRepository.findAll().stream().map((s) -> modelMapper.map(s, ShowsDetailedUsersInfoDto.class)).collect(Collectors.toList());
    }

    @Override
    public Optional<ShowsDetailedUsersInfoDto> get(UUID id) {
        return Optional.ofNullable(modelMapper.map(usersRepository.findById(id), ShowsDetailedUsersInfoDto.class));
    }

    @Override
    public void delete(UUID id) {
        if (usersRepository.findById(id).isPresent()) {
            usersRepository.deleteById(id);
        } else {
            throw new UsersNotFoundException(id);
        }
    }

    @Override
    public ShowsDetailedUsersInfoDto update(ShowsDetailedUsersInfoDto users) {
        if (usersRepository.findById(users.getId()).isPresent()) {
            return modelMapper.map(usersRepository.save(modelMapper.map(users, Users.class)), ShowsDetailedUsersInfoDto.class);
        } else {
            throw new UsersNotFoundException(users.getId());
        }
    }

    @Override
    public void addUserWithValidation(ShowsDetailedUsersInfoDto showsDetailedUsersInfoDto) {
        if (!this.validationUtil.isValid(showsDetailedUsersInfoDto)) {

            this.validationUtil
                    .violations(showsDetailedUsersInfoDto)
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);

            throw new IllegalArgumentException("Illegal arguments!");
        }

        Users user = this.modelMapper.map(showsDetailedUsersInfoDto, Users.class);


        this.usersRepository.saveAndFlush(user);
    }
}
