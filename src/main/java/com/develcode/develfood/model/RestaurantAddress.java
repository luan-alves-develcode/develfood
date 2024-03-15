package com.develcode.develfood.model;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Getter
@Embeddable
public class RestaurantAddress {

    private String street;

    private Integer number;

    private String neighbourhood;

    private String city;

    private String zipCode;
}
