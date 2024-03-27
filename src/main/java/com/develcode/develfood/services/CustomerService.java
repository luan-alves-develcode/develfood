package com.develcode.develfood.services;

import com.develcode.develfood.model.Customer;
import com.develcode.develfood.repository.CustomerRepository;
import com.develcode.develfood.services.exception.CnpjExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public boolean existsByCpf(String cpf) {
        return customerRepository.existsByCpf(cpf);
    }

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }
}
