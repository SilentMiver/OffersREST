package com.example.springdataforum.conf;
import com.example.springdataforum.conf.UniqueBrandNameValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = UniqueBrandNameValidator.class)
public @interface UniqueBrandName {
    String message() default "Brand already exists!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}