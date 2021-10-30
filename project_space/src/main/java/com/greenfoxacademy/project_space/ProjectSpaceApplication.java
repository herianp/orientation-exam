package com.greenfoxacademy.project_space;

import com.greenfoxacademy.project_space.db.PlanetRepository;
import com.greenfoxacademy.project_space.entity.Planet;
import com.greenfoxacademy.project_space.entity.Ship;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectSpaceApplication implements CommandLineRunner {

    private final PlanetRepository planetRepository;

    public ProjectSpaceApplication(PlanetRepository planetRepository) {
        this.planetRepository = planetRepository;
    }


    public static void main(String[] args) {
        SpringApplication.run(ProjectSpaceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        Ship ship = new Ship();
//        ship.setDocked(true);
//        ship.setMaxSpeed(9F);
//        ship.setName("Rocket");
//
//        Planet planet = new Planet();
//        planet.setName("Mars");
//        planet.setDocking_capacity(1);
//        planet.addShip(ship);
//
//        planetRepository.save(planet);
    }
}
