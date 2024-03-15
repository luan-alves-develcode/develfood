package com.develcode.develfood.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class AuthData {

    @Email @NotBlank
    private String email;

    @NotBlank
    private String password;

}
