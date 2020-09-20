package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadPlantDatabase {
    /**
     * Convenience class to initialize in-memory database with
     * some values.
     */
    @Bean
    CommandLineRunner initDatabase(PlantRepository repository) {
        return args -> {
            repository.save(new Plant("Trillium",
                    "grandiflorum", "White Trillum", "Beautiful"));
            repository.save(new Plant("Lilium", "michiganense", "Michigan Lily",
                    "Orange flower with recurved petals"));
        };
    }
}
