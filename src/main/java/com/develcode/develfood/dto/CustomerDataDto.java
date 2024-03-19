package com.develcode.develfood.dto;

import com.develcode.develfood.model.Customer;
import com.develcode.develfood.model.User;
import lombok.Getter;

@Getter
public class CustomerDataDto {

    private String firstName;

    private String lastName;

    private String cpf;

    private String email;

    private String phone;

    private String role;

    public CustomerDataDto(User savedUser, Customer savedCustomer) {
        this.firstName = savedCustomer.getFirstName();
        this.lastName = savedCustomer.getLastName();
        this.cpf = savedCustomer.getCpf();
        this.email = savedUser.getEmail();
        this.role = savedUser.getRole().name();
        this.phone = savedCustomer.getPhone();
    }
}
