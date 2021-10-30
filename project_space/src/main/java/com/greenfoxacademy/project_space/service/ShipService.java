package com.greenfoxacademy.project_space.service;

import com.greenfoxacademy.project_space.db.PlanetRepository;
import com.greenfoxacademy.project_space.db.ShipRepository;
import com.greenfoxacademy.project_space.entity.Planet;
import com.greenfoxacademy.project_space.entity.Ship;
import com.greenfoxacademy.project_space.model.ShipDto;
import com.greenfoxacademy.project_space.service.mapper.ShipMapper;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ShipService {

    private final ShipRepository shipRepository;
    private final PlanetRepository planetRepository;
    private final ShipMapper shipMapper;

    public ShipService(ShipRepository shipRepository, PlanetRepository planetRepository, ShipMapper shipMapper) {
        this.shipRepository = shipRepository;
        this.planetRepository = planetRepository;
        this.shipMapper = shipMapper;
    }

    public List<ShipDto> findAll() {
        return shipRepository.findAll().stream()
                .map(ship -> shipMapper.mapDto(ship))
                .collect(Collectors.toList());
    }

    public void changeDock(Long id) {
        Ship ship = shipRepository.findById(id).get();

        if (ship.isDocked()){
            ship.setDocked(false);
        } else {
            ship.setDocked(true);
        }

        shipRepository.save(ship);
    }

    public ShipDto findByName(String ship_name) {
        return shipMapper.mapDto(shipRepository.findByName(ship_name).get());
    }

    public void changePlanet(String ship_name, String planet_name) {
        Ship ship = shipRepository.findByName(ship_name).get();
        Planet planet = planetRepository.findByName(planet_name).get();

        ship.setPlanet(planet);
        shipRepository.save(ship);
    }

    public void save(ShipDto shipDto) {
        Ship ship = shipMapper.mapDto(shipDto);
        Optional<Planet> planet = planetRepository.findByName(ship.getPlanet().getName());
        System.out.println(planet.get().getName());
        planet.get().addShip(ship);
        planetRepository.save(planet.get());
    }

    public List<ShipDto> warpAtLeast(Float warpAtLeast) {
        return shipRepository.findByWarpAtLeast(warpAtLeast).stream()
                .map(ship -> shipMapper.mapDto(ship))
                .collect(Collectors.toList());
    }
}
