package com.greenfoxacademy.project_space.controller;

import com.greenfoxacademy.project_space.service.PlanetService;
import com.greenfoxacademy.project_space.service.ShipService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/sentShip")
    public RedirectView sentShip(Model model, @RequestParam String ship_name,
                                 RedirectAttributes redirectAttributes) {
        if (shipService.findByName(ship_name).isDocked()) {
            redirectAttributes.addAttribute("errorMessage", "The ship is Docked");
            return new RedirectView("/");
        }
        return new RedirectView("/");
    }

}
