package com.develcode.develfood.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Length;

public class CustomerSignUpDto {

    @Length(max = 50)
    private String firstName;
    @Length(max = 150)
    private String lastName;

    @Pattern(regexp = "[0-9]{3}[\\.][0-9]{3}[\\.][0-9]{3}[\\-][0-9]{2}")
    private String cpf;

    @Length(max = 18)
    private String phone;

    @Email
    @Length(max = 100)
    private String email;

    @Size(min = 8, max = 80)
    private String password;
}
