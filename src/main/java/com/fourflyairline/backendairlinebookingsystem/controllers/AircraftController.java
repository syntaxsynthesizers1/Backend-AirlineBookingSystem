package com.fourflyairline.backendairlinebookingsystem.controllers;

import com.fourflyairline.backendairlinebookingsystem.model.Aircraft;
import com.fourflyairline.backendairlinebookingsystem.services.AircraftService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AircraftController {


    private final AircraftService aircraftService;

    @GetMapping("/seatCount/{id}")
    public Aircraft getSeatCount(@PathVariable Long id) {
        return aircraftService.getSeatCounts(id);
    }
}
