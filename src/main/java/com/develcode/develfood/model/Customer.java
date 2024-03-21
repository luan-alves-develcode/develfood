package com.develcode.develfood.model;

import jakarta.persistence.CascadeType;
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
@Table(name = "customers")
public class Customer {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;

    private String lastName;

    private String cpf;

    private String phone;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Setter
    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<CustomerCard> cards;

    @Setter
    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<CustomerAddress> customerAddresses;

    public Customer(String firstName, String lastName, String cpf, String phone, User user) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.cpf = cpf;
        this.phone = phone;
        this.user = user;
    }

}

