package com.develcode.develfood.services;

import com.develcode.develfood.dto.CustomerSignUpDto;
import com.develcode.develfood.model.Customer;
import com.develcode.develfood.model.User;
import com.develcode.develfood.repository.CustomerRepository;
import com.develcode.develfood.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserService {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CustomerRepository customerRepository;

    public User signUpNewUser(CustomerSignUpDto userDto) throws EmailExistsException{
        if (emailExist(userDto.getEmail())) {
            throw new EmailExistsException(
                    "There is an account with that email adress:" + userDto.getEmail());
        }
        var user = new User(userDto.getEmail(), passwordEncoder.encode(userDto.getPassword()));

        userRepository.save(user);

        var customer = new Customer(userDto.getFirstName(), userDto.getLastName(), userDto.getCpf(), userDto.getPhone());

        customerRepository.save(customer);
    }
}
