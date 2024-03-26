package com.develcode.develfood.controller;

import com.develcode.develfood.dto.AuthData;
import com.develcode.develfood.dto.CustomerDataDto;
import com.develcode.develfood.dto.CustomerSignUpDto;
import com.develcode.develfood.dto.JwtTokenData;
import com.develcode.develfood.dto.RestaurantDataDto;
import com.develcode.develfood.dto.RestaurantSignUpDto;
import com.develcode.develfood.infra.security.JwtService;
import com.develcode.develfood.model.User;
import com.develcode.develfood.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;

    private final JwtService jwtService;

    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<JwtTokenData> login(@RequestBody @Valid AuthData authData) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(authData.getEmail(), authData.getPassword());
        var authentication = authenticationManager.authenticate(authenticationToken);

        var tokenJwt = jwtService.generateToken( (User) authentication.getPrincipal());

        return ResponseEntity.ok(new JwtTokenData(tokenJwt));
   }

    @PostMapping("/cliente/cadastro")
    public ResponseEntity<CustomerDataDto> signUp(@RequestBody @Valid CustomerSignUpDto customerSignUpDto) {
        var newUser = userService.newCustomerSignUp(customerSignUpDto);

        return ResponseEntity.ok(newUser);
    }

    @PostMapping("/restaurante/cadastro")
    public ResponseEntity<RestaurantDataDto> signUp(@RequestBody @Valid RestaurantSignUpDto restaurantSignUpDto) {
        var newRestaurant = userService.newRestaurantSignUp(restaurantSignUpDto);

        return ResponseEntity.ok(newRestaurant);
    }
}
