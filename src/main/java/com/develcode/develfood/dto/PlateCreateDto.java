package com.develcode.develfood.dto;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class PlateCreateDto {

    private String name;

    private String description;

    private BigDecimal price;

    private Long foodTypeId;
}
