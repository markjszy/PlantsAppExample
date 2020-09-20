package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlantController {
    private final PlantRepository repository;

    PlantController(PlantRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/plants/{id}")
    public Plant one(@RequestParam(value="id", defaultValue= "1") String id) {
        // Pretend we have retrieved a plant from some data store matching that id
        // Then turn it into an appropriate textual representation to return to the client
        var myPlant = new Plant((long) 1,
                "Trillium",
                "Grandiflorum",
                "White Trillium",
                "Beautiful");

        // Much better than the prior revision!
        return myPlant;
    }
}
