package com.develcode.develfood.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "customers")
public class Customer {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;

    private String lastName;

    private String cpf;

    private String phone;

    @OneToMany(mappedBy = "customerId", cascade={CascadeType.PERSIST})
    private List<CustomerCard> cards;

    @Embedded
    private Address address;
}

