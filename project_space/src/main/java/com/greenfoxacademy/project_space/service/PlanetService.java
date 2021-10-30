package com.greenfoxacademy.project_space.service;

import com.greenfoxacademy.project_space.db.PlanetRepository;
import com.greenfoxacademy.project_space.db.ShipRepository;
import com.greenfoxacademy.project_space.entity.Planet;
import com.greenfoxacademy.project_space.entity.Ship;
import com.greenfoxacademy.project_space.model.PlanetDto;
import com.greenfoxacademy.project_space.service.mapper.PlanetMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlanetService {

    private final PlanetRepository planetRepository;
    private final PlanetMapper planetMapper;
    private final ShipRepository shipRepository;

    public PlanetService(PlanetRepository planetRepository, PlanetMapper planetMapper, ShipRepository shipRepository) {
        this.planetRepository = planetRepository;
        this.planetMapper = planetMapper;
        this.shipRepository = shipRepository;
    }

    public List<PlanetDto> findAll() {
        return planetRepository.findAll().stream()
                .map(planet -> planetMapper.mapDto(planet))
                .collect(Collectors.toList());
    }

    public void delete(Long id) {
        List<Ship> list = planetRepository.getById(id).getPlanetList();
        planetRepository.delete(planetRepository.getById(id));

        Planet planet = planetRepository.findAll().get(0);

        if (list.size() > 0){
            for (Ship ship : list){
                planet.addShip(ship);
            }
            planetRepository.save(planet);
        }

//        for (Ship ship : list){
//            if(planet.getPlanetList().size() >= planet.getDocking_capacity()){
//                i++;
//                if (i>planetRepository.findAll().size()){
//                    shipRepository.delete(ship);
//                }
//                planet = planetRepository.findAll().get(i);
//            }
//            planet.addShip(ship);
//            planetRepository.save(planet);
//
//        }
    }
}
