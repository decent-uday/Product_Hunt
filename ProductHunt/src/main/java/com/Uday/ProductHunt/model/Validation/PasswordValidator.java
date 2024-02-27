package com.Uday.ProductHunt.model.Validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<validPassword, String> {

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        // Password should contain at least one lowercase letter, one digit, and one special character
        return password != null && password.matches("^(?=.*[a-z])(?=.*\\d)(?=.*[@#$&*]).+$");
    }
}
