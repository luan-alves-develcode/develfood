package com.develcode.develfood.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Table(name = "restaurants")
public class Restaurant {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String cnpj;

    private String phone;

    @Embedded
    private RestaurantAddress restaurantAddress;

    @Setter
    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<FoodType> foodTypeList;
}
