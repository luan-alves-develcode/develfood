package com.develcode.develfood.services;

import com.develcode.develfood.dto.CustomerSignUpDto;
import com.develcode.develfood.dto.CustomerDataDto;
import com.develcode.develfood.model.Customer;
import com.develcode.develfood.model.User;
import com.develcode.develfood.repository.CustomerRepository;
import com.develcode.develfood.repository.UserRepository;
import com.develcode.develfood.services.exception.EmailExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private PasswordEncoder passwordEncoder;

    private UserRepository userRepository;

    private CustomerRepository customerRepository;

    public CustomerDataDto newCustomerSignUp(CustomerSignUpDto userDto) throws EmailExistsException {
        if (userRepository.existsByEmail(userDto.getEmail())) {
            throw new EmailExistsException(
                    "Email address already in use: " + userDto.getEmail());
        }
        var user = new User(userDto.getEmail(), passwordEncoder.encode(userDto.getPassword()));

        var savedUser = userRepository.save(user);

        var customer = new Customer(userDto.getFirstName(), userDto.getLastName(), userDto.getCpf(), userDto.getPhone(), savedUser);

        var savedCustomer = customerRepository.save(customer);

        return new CustomerDataDto(savedUser, savedCustomer);
    }
}
