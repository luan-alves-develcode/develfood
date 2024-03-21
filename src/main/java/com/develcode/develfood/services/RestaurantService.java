package com.develcode.develfood.services;

import com.develcode.develfood.dto.CustomerDataDto;
import com.develcode.develfood.dto.CustomerSignUpDto;
import com.develcode.develfood.dto.RestaurantDataDto;
import com.develcode.develfood.dto.RestaurantSignUpDto;
import com.develcode.develfood.model.Customer;
import com.develcode.develfood.model.Restaurant;
import com.develcode.develfood.model.User;
import com.develcode.develfood.model.enums.Role;
import com.develcode.develfood.repository.CustomerRepository;
import com.develcode.develfood.repository.RestaurantRepository;
import com.develcode.develfood.repository.UserRepository;
import com.develcode.develfood.services.exception.CnpjExistsException;
import com.develcode.develfood.services.exception.EmailExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
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
