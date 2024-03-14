package com.develcode.develfood.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;

import java.util.Date;

@Entity
@Getter
public class RestaurantPromotions {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    private Restaurant restaurant;

    private String name;

    private Float percent;

    private Date initialDate;

    private Date finalDate;
}
