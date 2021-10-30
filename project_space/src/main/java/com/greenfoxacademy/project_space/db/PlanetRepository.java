package com.greenfoxacademy.project_space.db;

import com.greenfoxacademy.project_space.entity.Planet;
import com.greenfoxacademy.project_space.entity.Ship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlanetRepository extends JpaRepository<Planet, Long> {

    Optional<Planet> findByName(String name);
}
