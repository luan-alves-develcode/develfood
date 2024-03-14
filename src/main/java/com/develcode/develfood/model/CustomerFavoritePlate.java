package com.develcode.develfood.model;

import com.develcode.develfood.model.enums.Plate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Table(name = "customer_favorite_plates")
public class CustomerFavoritePlate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Setter
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Setter
    @ManyToOne
    @JoinColumn(name = "plate_id")
    private Plate plate;
}
