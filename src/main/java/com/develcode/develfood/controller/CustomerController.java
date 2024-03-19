package com.develcode.develfood.controller;


import com.develcode.develfood.dto.CustomerDataDto;
import com.develcode.develfood.dto.CustomerSignUpDto;
import com.develcode.develfood.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
@RequiredArgsConstructor
public class CustomerController {

    private UserService userService;

    @PostMapping("/cadastro")
    public ResponseEntity<CustomerDataDto> signUp(@RequestBody @Valid CustomerSignUpDto customerSignUpDto) {
        var newUser = userService.newCustomerSignUp(customerSignUpDto);

        return ResponseEntity.ok(newUser);
    }
}
