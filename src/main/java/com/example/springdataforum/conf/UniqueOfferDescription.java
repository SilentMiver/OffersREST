package com.example.springdataforum.conf;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = UniqueOfferDescriptionValidator.class)
public @interface UniqueOfferDescription {
    String message() default "Offer already exists!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}