package com.example.moviedb.dto;

import com.example.moviedb.model.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@UsernamePasswordNotSame(message = "Username and password must not be the same")
@Getter
@Setter
public class UserRequestDto {

    @NotBlank(message = "Username is required")
    @Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters")
    private String username;

    @NotBlank(message = "Password is required")
    @Size(min = 6, max = 20, message = "Password must be between 6 and 20 characters")
    private String password;

    @NotNull(message = "Role must be provided and be either USER or ADMIN")
    private Role role; // Enum (USER, ADMIN)
}