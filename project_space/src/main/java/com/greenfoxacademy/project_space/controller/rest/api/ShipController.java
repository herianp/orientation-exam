package com.greenfoxacademy.project_space.controller.rest.api;

import com.greenfoxacademy.project_space.service.ShipService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShipController {

    private final ShipService shipservice;

    public ShipController(ShipService service) {
        this.shipservice = service;
    }

    @GetMapping("ships")
    public ResponseEntity warpAtLeast(@RequestParam Float warpAtLeast){
        return ResponseEntity.status(HttpStatus.OK).body(shipservice.warpAtLeast(warpAtLeast));
    }
}
