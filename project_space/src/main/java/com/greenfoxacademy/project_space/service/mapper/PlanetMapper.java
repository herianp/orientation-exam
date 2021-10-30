package com.greenfoxacademy.project_space.service.mapper;

import com.greenfoxacademy.project_space.entity.Planet;
import com.greenfoxacademy.project_space.model.PlanetDto;
import org.mapstruct.Mapper;

@Mapper
public interface PlanetMapper {

    Planet mapDto(PlanetDto planetDto);

    PlanetDto mapDto(Planet planet);
}
