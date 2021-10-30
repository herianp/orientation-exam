package com.greenfoxacademy.project_space.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShipDto {

    private Long id;
    private Float maxSpeed;
    private String name;
    private boolean isDocked;
    private String planet;
}
