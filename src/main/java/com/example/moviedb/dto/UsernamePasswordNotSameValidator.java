package com.example.moviedb.dto;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UsernamePasswordNotSameValidator implements ConstraintValidator<UsernamePasswordNotSame, UserRequestDto> {

    @Override
    public boolean isValid(UserRequestDto dto, ConstraintValidatorContext context) {
        if (dto == null) {
            // Let @NotNull (if applied) handle null cases.
            return true;
        }
        if (dto.getUsername() == null || dto.getPassword() == null) {
            // Other validations will handle null checks.
            return true;
        }
        return !dto.getUsername().equals(dto.getPassword());
    }
}