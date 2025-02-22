package com.example.moviedb.dto;

import com.example.moviedb.model.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDto {
    private String username;
    private String password;
    private Role role; // Enum (USER, ADMIN)
}
