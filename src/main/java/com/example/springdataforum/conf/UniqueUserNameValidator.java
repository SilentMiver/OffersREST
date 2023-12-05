package com.example.springdataforum.conf;

import com.example.springdataforum.repositories.UsersRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class UniqueUserNameValidator implements ConstraintValidator<UniqueUserName, String> {

    private UsersRepository usersRepository;

    public UniqueUserNameValidator() {
    }

    @Autowired
    public void setUsersRepository(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }


    @Override
    public boolean isValid(String name, ConstraintValidatorContext constraintValidatorContext) {

        return usersRepository.findByUsername(name).isEmpty();
    }
}
