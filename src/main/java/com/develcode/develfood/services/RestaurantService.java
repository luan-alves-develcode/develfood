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

    public Restaurant save(Restaurant restaurant) {
        if (restaurantRepository.existsByCnpj(restaurant.getCnpj())) {
            throw new CnpjExistsException("Cnpj already in use: " + restaurant.getCnpj());
        }

        return restaurantRepository.save(restaurant);
    }
}
