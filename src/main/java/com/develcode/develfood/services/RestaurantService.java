package com.develcode.develfood.services;

import com.develcode.develfood.model.Restaurant;
import com.develcode.develfood.repository.RestaurantRepository;
import com.develcode.develfood.services.exception.CnpjExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public boolean existsByCnpj(String cnpj) {
        return restaurantRepository.existsByCnpj(cnpj);
    }

    public Restaurant save(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }
}
