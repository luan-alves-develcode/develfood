package com.develcode.develfood.services;

import com.develcode.develfood.dto.CustomerDataDto;
import com.develcode.develfood.dto.CustomerSignUpDto;
import com.develcode.develfood.dto.RestaurantDataDto;
import com.develcode.develfood.dto.RestaurantSignUpDto;
import com.develcode.develfood.exception.ValidationException;
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
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    private final CustomerService customerService;

    private final RestaurantService restaurantService;

    public CustomerDataDto newCustomerSignUp(CustomerSignUpDto customerSignUpDto) throws ValidationException {
        if (userRepository.existsByEmail(customerSignUpDto.getEmail())) {
            throw new EmailExistsException(
                    "Email address already in use: " + customerSignUpDto.getEmail());
        }

        if (customerService.existsByCpf(customerSignUpDto.getCpf())) {
            throw new CnpjExistsException(
                    "CPF already in use: " + customerSignUpDto.getCpf());
        }

        var user = new User(customerSignUpDto.getEmail(), passwordEncoder.encode(customerSignUpDto.getPassword()), Role.CUSTOMER);

        var savedUser = userRepository.save(user);

        var customer = new Customer(customerSignUpDto.getFirstName(), customerSignUpDto.getLastName(), customerSignUpDto.getCpf(), customerSignUpDto.getPhone(), savedUser);

        var savedCustomer = customerService.save(customer);

        return new CustomerDataDto(savedUser, savedCustomer);
    }

    public RestaurantDataDto newRestaurantSignUp(RestaurantSignUpDto restaurantSignUpDto) throws ValidationException {
        if (userRepository.existsByEmail(restaurantSignUpDto.getEmail())) {
            throw new EmailExistsException(
                    "Email address already in use: " + restaurantSignUpDto.getEmail());
        }

        if (restaurantService.existsByCnpj(restaurantSignUpDto.getCnpj())) {
            throw new CnpjExistsException(
                    "CNPJ already in use: " + restaurantSignUpDto.getCnpj());
        }

        var user = new User(restaurantSignUpDto.getEmail(), passwordEncoder.encode(restaurantSignUpDto.getPassword()), Role.RESTAURANT);

        var savedUser = userRepository.save(user);

        var restaurant = new Restaurant(restaurantSignUpDto, savedUser);

        var savedRestaurant = restaurantService.save(restaurant);

        return new RestaurantDataDto(savedUser, savedRestaurant);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User credential are invalid"));
    }
}
