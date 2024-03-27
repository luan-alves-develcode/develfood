package com.develcode.develfood.repository;

import com.develcode.develfood.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    boolean existsByCnpj(String cnpj);

}
