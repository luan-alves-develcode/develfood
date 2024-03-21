package com.develcode.develfood.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "restaurants")
public class Restaurant {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String cnpj;

    private String phone;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Embedded
    private RestaurantAddress restaurantAddress;

    private boolean isActive;

    @Setter
    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<FoodType> foodTypeList;

}
