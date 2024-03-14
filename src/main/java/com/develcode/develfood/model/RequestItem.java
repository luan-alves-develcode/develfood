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

import java.math.BigDecimal;

@Entity
@Getter
@Table(name = "request_items")
public class RequestItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "request_id")
    private Request request;

    @Setter
    @ManyToOne
    @JoinColumn(name = "plate_id")
    private Plate plate;

    private String plateName;

    private Integer quantity;

    private BigDecimal price;

    private String observation;

}
