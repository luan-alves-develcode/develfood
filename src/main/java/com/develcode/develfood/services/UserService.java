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
import com.develcode.develfood.services.exception.validation.EmailExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    private final CustomerRepository customerRepository;

    private final RestaurantRepository restaurantRepository;

    public CustomerDataDto newCustomerSignUp(CustomerSignUpDto userDto) throws EmailExistsException {
        if (userRepository.existsByEmail(userDto.getEmail())) {
            throw new EmailExistsException(
                    "Email address already in use: " + userDto.getEmail());
        }
        var user = new User(userDto.getEmail(), passwordEncoder.encode(userDto.getPassword()));
        user.setRole(Role.CUSTOMER);

        var savedUser = userRepository.save(user);

        var customer = new Customer(userDto.getFirstName(), userDto.getLastName(), userDto.getCpf(), userDto.getPhone(), savedUser);

        var savedCustomer = customerRepository.save(customer);

        return new CustomerDataDto(savedUser, savedCustomer);
    }

    public RestaurantDataDto newRestaurantSignUp(RestaurantSignUpDto restaurantSignUpDto) throws EmailExistsException {
        if (userRepository.existsByEmail(restaurantSignUpDto.getEmail())) {
            throw new EmailExistsException(
                    "Email address already in use: " + restaurantSignUpDto.getEmail());
        }
        var user = new User(restaurantSignUpDto.getEmail(), passwordEncoder.encode(restaurantSignUpDto.getPassword()));
        user.setRole(Role.RESTAURANT);

        var savedUser = userRepository.save(user);

        var restaurant = new Restaurant(restaurantSignUpDto, savedUser);

        var savedRestaurant = restaurantRepository.save(restaurant);

        return new RestaurantDataDto(savedUser, savedRestaurant);
    }
}
