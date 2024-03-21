package com.develcode.develfood.dto;

import com.develcode.develfood.model.Restaurant;
import com.develcode.develfood.model.User;

public class RestaurantDataDto {

    private String name;

    private String cnpj;

    private String email;

    private String phone;

    private String role;

    public RestaurantDataDto(User savedUser, Restaurant savedRestaurant) {
        this.name = savedRestaurant.getName();
        this.cnpj = savedRestaurant.getCnpj();
        this.email = savedUser.getEmail();
        this.role = savedUser.getRole().name();
        this.phone = savedRestaurant.getPhone();
    }
}
