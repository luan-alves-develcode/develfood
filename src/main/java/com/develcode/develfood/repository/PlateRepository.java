package com.develcode.develfood.repository;

import com.develcode.develfood.model.Plate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlateRepository extends JpaRepository<Plate, Long> {
}
