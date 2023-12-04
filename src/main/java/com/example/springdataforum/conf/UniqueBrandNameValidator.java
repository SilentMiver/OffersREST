package com.example.springdataforum.conf;

import com.example.springdataforum.repositories.BrandsRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class UniqueBrandNameValidator implements ConstraintValidator<UniqueBrandName, String> {

    private BrandsRepository brandsRepository;

    public UniqueBrandNameValidator() {
    }

    @Autowired
    public void setBrandsRepository(BrandsRepository brandsRepository) {
        this.brandsRepository = brandsRepository;
    }


    @Override
    public boolean isValid(String name, ConstraintValidatorContext constraintValidatorContext) {

        return brandsRepository.findByName(name).isEmpty();
    }
}
