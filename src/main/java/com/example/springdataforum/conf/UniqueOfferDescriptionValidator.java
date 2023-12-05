package com.example.springdataforum.conf;

import com.example.springdataforum.repositories.OffersRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class UniqueOfferDescriptionValidator implements ConstraintValidator<UniqueOfferDescription, String> {

    private OffersRepository offersRepository;

    public UniqueOfferDescriptionValidator() {
    }

    @Autowired
    public void setOffersRepository(OffersRepository offersRepository) {
        this.offersRepository = offersRepository;
    }


    @Override
    public boolean isValid(String name, ConstraintValidatorContext constraintValidatorContext) {

        return offersRepository.findByDescription(name).isEmpty();
    }
}
