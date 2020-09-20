package com.example.demo;

import org.springframework.web.bind.annotation.*;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.CollectionModel;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class PlantController {
    private final PlantRepository repository;

    PlantController(PlantRepository repository) {
        this.repository = repository;
    }

    // Aggregate operations

    @GetMapping("/plants")
    CollectionModel<EntityModel<Plant>> all() {
        List<EntityModel<Plant>> plants = repository.findAll().stream()
                .map(plant -> EntityModel.of(plant,
                        linkTo(methodOn(PlantController.class).one(plant.getId())).withSelfRel(),
                        linkTo(methodOn(PlantController.class).all()).withRel("plants")))
                .collect(Collectors.toList());
        return CollectionModel.of(plants, linkTo(methodOn(PlantController.class).all()).withSelfRel());
    }

    @PostMapping("/plants")
    Plant newPlant(@RequestBody Plant newPlant) {
        return repository.save(newPlant);
    }

    @GetMapping("/plants/{id}")
    EntityModel<Plant> one(@PathVariable Long id) {
        var plant = repository.findById(id).orElseThrow(() -> new PlantNotFoundException(id));
        return EntityModel.of(plant,
                linkTo(methodOn(PlantController.class).one(id)).withSelfRel(),
                linkTo(methodOn(PlantController.class).all()).withRel("employees"));
    }

    @PutMapping("/plants/{id}")
    Plant replacePlant(@RequestBody Plant newPlant, @PathVariable Long id) {
        return repository.findById(id)
                .map(plant -> {
                    plant.setGenus(newPlant.getGenus());
                    plant.setSpecies(newPlant.getSpecies());
                    plant.setCommonName(newPlant.getCommonName());
                    plant.setDescription(newPlant.getDescription());
                    return repository.save(plant);
                })
                .orElseGet(() -> {
                    newPlant.setId(id);
                    return repository.save(newPlant);
                });
    }

    @DeleteMapping("/plants/{id}")
    void deletePlant(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
