package com.Uday.ProductHunt.model.Validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordValidator.class)
public @interface validPassword {
    String message() default "Invalid password";
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

