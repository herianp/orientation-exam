package com.greenfoxacademy.project_space.service;

import com.greenfoxacademy.project_space.db.PlanetRepository;
import com.greenfoxacademy.project_space.model.PlanetDto;
import com.greenfoxacademy.project_space.service.mapper.PlanetMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlanetService {

    private final PlanetRepository planetRepository;
    private final PlanetMapper planetMapper;

    public PlanetService(PlanetRepository planetRepository, PlanetMapper planetMapper) {
        this.planetRepository = planetRepository;
        this.planetMapper = planetMapper;
    }

    public List<PlanetDto> findAll() {
        return planetRepository.findAll().stream()
                .map(planet -> planetMapper.mapDto(planet))
                .collect(Collectors.toList());
    }
}
