package com.greenfoxacademy.project_space.service.mapper;

import com.greenfoxacademy.project_space.entity.Ship;
import com.greenfoxacademy.project_space.model.ShipDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ShipMapper {

    @Mapping(source = "planet",target = "planet.name")
    Ship mapDto(ShipDto shipDto);

    @Mapping(source = "planet.name",target = "planet")
    ShipDto mapDto(Ship ship);
}
