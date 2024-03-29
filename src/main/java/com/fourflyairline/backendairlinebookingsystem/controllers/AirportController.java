package com.fourflyairline.backendairlinebookingsystem.controllers;

import com.fourflyairline.backendairlinebookingsystem.services.AirportService;
import com.fourflyairline.backendairlinebookingsystem.services.FlightService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/airports")
@AllArgsConstructor
public class AirportController {

    private final AirportService airportService;

    @GetMapping("/origins")
    public ResponseEntity<?> getAirports(@RequestParam int page, @RequestParam int size){
        return ResponseEntity.ok(airportService.getAirports(page, size));
    }
}
