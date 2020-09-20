package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlantController {
    // TODO: fill out remaining HTTP verbs (among other things...)

    @GetMapping("/plants/{id}")
    public String one(@RequestParam(value="id", defaultValue= "1") String id) {
        // Pretend we have retrieved a plant from some data store matching that id
        // Then turn it into an appropriate textual representation to return to the client
        var myPlant = new Plant((long) 1,
                "Trillum",
                "Grandiflorum",
                "White Trillium",
                "Beautiful");


        // NB: all this is for illustrative purposes to motivate the use of
        // Spring features in subsequent revisions. This is *not* how you would
        // actually want to write services! : )
        return String.format(
                "{\"id\": \"%d\"," +
                "\"genus\": \"%s\"," +
                "\"species\": \"%s\"," +
                "\"commonName\": \"%s\"," +
                        "\"description\": \"%s\"",
                myPlant.getId(),
                myPlant.getGenus(),
                myPlant.getSpecies(),
                myPlant.getCommonName(),
                myPlant.getDescription());
    }
}
