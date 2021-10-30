package com.greenfoxacademy.project_space.db;

import com.greenfoxacademy.project_space.entity.Ship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShipRepository extends JpaRepository<Ship,Long> {

    Optional<Ship> findByName(String name);
}
