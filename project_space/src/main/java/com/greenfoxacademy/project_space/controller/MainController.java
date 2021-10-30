package com.greenfoxacademy.project_space.controller;

import com.greenfoxacademy.project_space.model.ShipDto;
import com.greenfoxacademy.project_space.service.PlanetService;
import com.greenfoxacademy.project_space.service.ShipService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class MainController {

    private final ShipService shipService;
    private final PlanetService planetService;

    public MainController(ShipService shipService, PlanetService planetService) {
        this.shipService = shipService;
        this.planetService = planetService;
    }


    @GetMapping("/")
    public String main(Model model,@RequestParam(required = false) String errorMessage) {
        model.addAttribute("planetList", planetService.findAll());
        model.addAttribute("shipList", shipService.findAll());
        if (errorMessage != null) {
            model.addAttribute("errorMessage", errorMessage);
        }
        return "index";
    }

    @GetMapping("/dock/{id}")
    public String dockChange(@PathVariable Long id) {
        shipService.changeDock(id);
        return "redirect:/";
    }

    @GetMapping("/ship/move")
    public RedirectView moveShip(Model model, @RequestParam String ship_name,
                                 @RequestParam String planet_name,
                                 RedirectAttributes redirectAttributes) {
        if (shipService.findByName(ship_name).isDocked()) {
            redirectAttributes.addAttribute("errorMessage", "The ship is Docked");
            return new RedirectView("/");
        }

        shipService.changePlanet(ship_name,planet_name);
        return new RedirectView("/");
    }

    @PostMapping("/ships")
    public String createShip(@ModelAttribute ShipDto shipDto){
        System.out.println(shipDto.getName());
        shipService.save(shipDto);
        return "redirect:/";
    }

    @DeleteMapping("/planets/{id}")
    public ResponseEntity deletePlanet(@PathVariable Long id){

        planetService.delete(id);
        return ResponseEntity.ok().build();
    }

}
