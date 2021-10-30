package com.greenfoxacademy.project_space.service;

import com.greenfoxacademy.project_space.db.ShipRepository;
import com.greenfoxacademy.project_space.entity.Ship;
import com.greenfoxacademy.project_space.model.ShipDto;
import com.greenfoxacademy.project_space.service.mapper.ShipMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShipService {

    private final ShipRepository shipRepository;
    private final ShipMapper shipMapper;

    public ShipService(ShipRepository shipRepository, ShipMapper shipMapper) {
        this.shipRepository = shipRepository;
        this.shipMapper = shipMapper;
    }

    public List<ShipDto> findAll() {
        return shipRepository.findAll().stream()
                .map(ship -> shipMapper.mapDto(ship))
                .collect(Collectors.toList());
    }
}
