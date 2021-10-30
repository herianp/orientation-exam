package com.greenfoxacademy.project_space.controller.rest.api;

import com.greenfoxacademy.project_space.service.PlanetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlanetController {

    private final PlanetService planetService;

    public PlanetController(PlanetService planetService) {
        this.planetService = planetService;
    }

    @DeleteMapping("/planets/{id}")
    public ResponseEntity deletePlanet(@PathVariable Long id){

        planetService.delete(id);
        return ResponseEntity.ok().build();
    }
}
