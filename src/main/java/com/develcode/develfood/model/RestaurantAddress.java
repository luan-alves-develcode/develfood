package com.develcode.develfood.model;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Embeddable
@NoArgsConstructor
public class RestaurantAddress {

    private String street;

    private Integer number;

    private String neighbourhood;

    private String city;

    private String zipCode;

    public RestaurantAddress(String street, Integer number, String neighbourhood, String city, String zipcode) {
        this.street = street;
        this.number = number;
        this.neighbourhood = neighbourhood;
        this.city = city;
        this.zipCode = zipcode;
    }
}
