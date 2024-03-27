package com.develcode.develfood.services;

import com.develcode.develfood.dto.FoodTypeListDto;
import com.develcode.develfood.repository.FoodTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodTypeService {

    private final FoodTypeRepository foodTypeRepository;

    public List<FoodTypeListDto> getAllByIsActiveTrue() {
        return foodTypeRepository.findByIsActiveTrue().stream().map(FoodTypeListDto::new).toList();
    }

}
