package com.develcode.develfood.repository;

import com.develcode.develfood.model.FoodType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodTypeRepository extends JpaRepository<FoodType, Long> {

    List<FoodType> findByIsActiveTrue();

}
