package com.greenfoxacademy.project_space.db;

import com.greenfoxacademy.project_space.entity.Ship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShipRepository extends JpaRepository<Ship,Long> {

    Optional<Ship> findByName(String name);

    @Query("select s from Ship s where s.maxSpeed >= :number order by s.maxSpeed")
    List<Ship> findByWarpAtLeast(Float number);
}
