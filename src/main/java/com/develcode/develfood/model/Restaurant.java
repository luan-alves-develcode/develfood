package com.develcode.develfood.model;

import com.develcode.develfood.dto.RestaurantSignUpDto;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
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

    @Embedded
    private RestaurantAddress restaurantAddress;

    private boolean isActive;

    @Setter
    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<FoodType> foodTypeList;

    public Restaurant(RestaurantSignUpDto restaurantDto, User savedUser) {
        this.name = restaurantDto.getName();
        this.cnpj = restaurantDto.getCnpj();
        this.phone = restaurantDto.getPhone();
        this.restaurantAddress = new RestaurantAddress(restaurantDto.getStreet(), restaurantDto.getNumber(), restaurantDto.getNeighbourhood(), restaurantDto.getCity(), restaurantDto.getZipcode());
        this.user = savedUser;
        this.isActive = true;
    }
}
