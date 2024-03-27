package com.develcode.develfood.model;

import com.develcode.develfood.dto.RestaurantSignUpDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "restaurants")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    private String cnpj;

    private String phone;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    private boolean isActive;

    @OneToOne
    @JoinColumn(name = "food_types_id")
    private FoodType foodType;

    public Restaurant(RestaurantSignUpDto restaurantDto, User savedUser) {
        this.name = restaurantDto.getName();
        this.cnpj = restaurantDto.getCnpj();
        this.phone = restaurantDto.getPhone();
        this.address = new Address(restaurantDto.getStreet(), restaurantDto.getNumber(), restaurantDto.getNeighbourhood(), restaurantDto.getCity(), restaurantDto.getZipcode());
        this.user = savedUser;
        this.isActive = true;
    }
}
