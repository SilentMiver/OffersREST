package com.example.springdataforum.services.impl.impl;

import com.example.springdataforum.conf.utilities.ValidationUtil;
import com.example.springdataforum.controllers.exceptions.UsersIsExistException;
import com.example.springdataforum.controllers.exceptions.UsersNotFoundException;
import com.example.springdataforum.dto.AddUsersDto;
import com.example.springdataforum.dto.ShowDetailedUsersInfoDto;
import com.example.springdataforum.dto.ShowUsersInfoDto;

import com.example.springdataforum.dto.UpdateUserDto;
import com.example.springdataforum.models.Users;
import com.example.springdataforum.repositories.UsersRepository;
import com.example.springdataforum.services.impl.UsersService;
import jakarta.validation.ConstraintViolation;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@EnableCaching
public class UsersServiceImpl implements UsersService {

    private final ModelMapper modelMapper;
    private UsersRepository usersRepository;
    private final ValidationUtil validationUtil;
    private static final Logger logger = LoggerFactory.getLogger(UsersServiceImpl.class);

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
    @Cacheable("users")
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

    public Users getUser(String userName) {
        System.out.println(userName);
        return usersRepository.findByUsername(userName)
                .orElseThrow(() -> new UsersNotFoundException(userName + " was not found!"));
    }
    @Override
    public void addUser(AddUsersDto userDto) {
        usersRepository.saveAndFlush(modelMapper.map(userDto, Users.class));
    }

    @Override
    @Cacheable("users")
    public List<ShowUsersInfoDto> getAllUsers() {
        return usersRepository.findAll().stream().map(user -> modelMapper.map(user, ShowUsersInfoDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ShowUsersInfoDto getUserByName(String userName) {
        return usersRepository.findByUsername(userName).stream().map(user -> modelMapper.map(user, ShowUsersInfoDto.class)).toList().get(0);

    }

    @Override
    public ShowDetailedUsersInfoDto userDetails(String userName) {
        return modelMapper.map(usersRepository.findByUsername(userName).orElse(null), ShowDetailedUsersInfoDto.class);
    }

    @Override
    @CacheEvict(value = "users")
    public void removeUser(String userName) {
        usersRepository.deleteByUsername(userName);


    }
    @Cacheable("users")
    public List<ShowUsersInfoDto> allUsers() {
        return usersRepository.findAll().stream().map(users -> modelMapper.map(users, ShowUsersInfoDto.class))
                .collect(Collectors.toList());
    }
    @CacheEvict(value = "users")
    @Override
    public void updateUser(String userName, UpdateUserDto updateUserDto) {
        logger.info("Updating user: {}", userName);
        Users existingUser = usersRepository.findByUsername(userName).orElse(null);
        if (existingUser == null) {
            throw new UsersNotFoundException(userName);
        }

        // Update the fields
        existingUser.setFirstName(updateUserDto.getFirstName());
        existingUser.setLastName(updateUserDto.getLastName());
        existingUser.setPassword(updateUserDto.getPassword());
        existingUser.setModified(new Date());

        // Save the updated user
        usersRepository.save(existingUser);
        logger.info("User {} updated successfully", userName);
    }


}
