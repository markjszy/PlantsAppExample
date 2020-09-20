package com.example.demo;

public class Plant {
    private Long id;
    private String genus;
    private String species;
    private String commonName;
    private String description;

    public Plant() {}

    public Plant(Long id, String genus, String species, String commonName, String description) {
        this.id = id;
        this.genus = genus;
        this.species = species;
        this.commonName = commonName;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGenus() {
        return genus;
    }

    public void setGenus(String genus) {
        this.genus = genus;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
