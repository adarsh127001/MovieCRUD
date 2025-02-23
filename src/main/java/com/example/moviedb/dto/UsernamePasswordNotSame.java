package com.example.moviedb.dto;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = UsernamePasswordNotSameValidator.class)
@Target({ TYPE })
@Retention(RUNTIME)
public @interface UsernamePasswordNotSame {

    String message() default "Username and password must not be the same";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}