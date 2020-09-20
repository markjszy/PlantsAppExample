package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlantController {
    private final PlantRepository repository;

    PlantController(PlantRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/plants")
    List<Plant> all() {
        return repository.findAll();
    }

    @GetMapping("/plants/{id}")
    public Plant one(@PathVariable Long id) {
        // Note: we will improve this situation with custom error handling in the next revision
        return repository.findById(id).orElseThrow(() -> new PlantNotFoundException(id));
    }
}
