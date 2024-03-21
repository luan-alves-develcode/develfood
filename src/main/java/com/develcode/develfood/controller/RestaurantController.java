package com.develcode.develfood.controller;


import com.develcode.develfood.dto.CustomerDataDto;
import com.develcode.develfood.dto.CustomerSignUpDto;
import com.develcode.develfood.dto.RestaurantDataDto;
import com.develcode.develfood.dto.RestaurantSignUpDto;
import com.develcode.develfood.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restaurantes")
public class RestaurantController {

    @Autowired
    private UserService userService;

    @PostMapping("/cadastro")
    public ResponseEntity<RestaurantDataDto> signUp(@RequestBody @Valid RestaurantSignUpDto restaurantSignUpDto) {
        var newRestaurant = userService.newRestaurantSignUp(restaurantSignUpDto);

        return ResponseEntity.ok(newRestaurant);
    }
}
