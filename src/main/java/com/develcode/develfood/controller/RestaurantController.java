package com.develcode.develfood.controller;


import com.develcode.develfood.services.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/restaurantes")
public class RestaurantController {

    private final RestaurantService restaurantService;

//    @GetMapping
//    public ResponseEntity<Page<RestaurantListDataDto>> list(Pageable pageable) {
//        var page = restaurantService.findAllByActive(pageable).map(RestaurantListDataDto::new);
//
//        return ResponseEntity.ok(page);
//    }
}
