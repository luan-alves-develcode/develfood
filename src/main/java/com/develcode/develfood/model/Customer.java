package com.develcode.develfood.model;

import jakarta.persistence.CascadeType;
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
@Table(name = "customers")
public class Customer {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;

    private String lastName;

    private String cpf;

    private String phone;

    @Setter
    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<CustomerCard> cards;

    @Setter
    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private CustomerAddress customerAddress;
}

