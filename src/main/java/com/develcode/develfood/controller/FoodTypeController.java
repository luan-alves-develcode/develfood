package com.develcode.develfood.controller;

import com.develcode.develfood.dto.FoodTypeListDto;
import com.develcode.develfood.services.FoodTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
@RequiredArgsConstructor
public class FoodTypeController {

    private final FoodTypeService foodTypeService;

    @GetMapping
    public ResponseEntity<List<FoodTypeListDto>> listAllActive() {
        return ResponseEntity.ok(foodTypeService.getAllByIsActiveTrue());
    }
}
