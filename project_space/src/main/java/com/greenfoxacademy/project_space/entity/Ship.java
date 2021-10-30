package com.greenfoxacademy.project_space.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Float maxSpeed = 1F;
    private boolean isDocked = false;

    @ManyToOne
    @JoinColumn(name = "planet_id")
    private Planet planet;
}
