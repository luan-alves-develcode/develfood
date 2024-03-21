package com.develcode.develfood.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

@Getter
public class RestaurantSignUpDto {

    @Length(max = 100)
    private String name;

    @Pattern(regexp = "^\\d{2}\\d{3}\\d{3}\\d{4}\\d{2}$")
    @Length(min = 14, max = 14)
    private String cnpj;

    @Length(max = 18)
    private String phone;

    @Email
    @Length(max = 100)
    private String email;

    @Size(min = 8, max = 80)
    private String password;

    @Size(max = 255)
    private String street;

    @Positive
    private Integer number;

    @Size(max = 255)
    private String neighbourhood;

    @Size(max = 100)
    private String city;

    @Size(max = 8, min = 8)
    private String zipcode;

}
