package com.example.springdataforum.conf;

import com.example.springdataforum.repositories.ModelsRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class UniqueModelNameValidator implements ConstraintValidator<UniqueModelName, String> {

    private ModelsRepository modelsRepository;

    public UniqueModelNameValidator() {
    }

    @Autowired
    public void setModelsRepository(ModelsRepository modelsRepository) {
        this.modelsRepository = modelsRepository;
    }


    @Override
    public boolean isValid(String name, ConstraintValidatorContext constraintValidatorContext) {

        return modelsRepository.findByName(name).isEmpty();
    }
}
