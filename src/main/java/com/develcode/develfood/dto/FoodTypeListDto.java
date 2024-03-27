package com.develcode.develfood.dto;

import com.develcode.develfood.model.FoodType;
import lombok.Getter;

@Getter
public class FoodTypeListDto {

    private Long id;

    private String name;

    public FoodTypeListDto(FoodType foodType) {
        this.id = foodType.getId();
        this.name = foodType.getName();
    }
}
