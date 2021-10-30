package com.greenfoxacademy.project_space.model;

import com.greenfoxacademy.project_space.entity.Ship;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlanetDto {

    private Long id;

    private String name;
    private Integer docking_capacity;
    private List<Ship> planetList = new ArrayList<>();
}
