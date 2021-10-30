package com.greenfoxacademy.project_space.controller;

import com.greenfoxacademy.project_space.service.PlanetService;
import com.greenfoxacademy.project_space.service.ShipService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    private final ShipService shipService;
    private final PlanetService planetService;

    public MainController(ShipService shipService, PlanetService planetService) {
        this.shipService = shipService;
        this.planetService = planetService;
    }


    @GetMapping()
    public String main(Model model){
        model.addAttribute("planetList",planetService.findAll());
        model.addAttribute("shipList",shipService.findAll());
        return "index";
    }

}
