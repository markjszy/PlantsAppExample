package com.example.demo;

public class PlantNotFoundException extends RuntimeException {
    PlantNotFoundException(Long id) {
        super(String.format("Could not find plant %d", id));
    }
}
