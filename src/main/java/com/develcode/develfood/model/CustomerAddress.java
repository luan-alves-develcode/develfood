package com.develcode.develfood.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import lombok.Getter;

@Entity
@Getter
public class CustomerAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String street;

    private Integer number;

    private String neighbourhood;

    private String city;

    private String zipCode;

    @JoinColumn(name = "customer_id")
    private Customer customer;
}
