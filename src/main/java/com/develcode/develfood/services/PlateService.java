package com.develcode.develfood.services;

import com.develcode.develfood.model.Plate;
import com.develcode.develfood.repository.PlateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlateService {

    private final PlateRepository plateRepository;

    public Plate save(Plate plate) {
        return plateRepository.save(plate);
    }

}
