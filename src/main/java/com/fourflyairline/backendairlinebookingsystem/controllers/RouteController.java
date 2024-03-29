package com.fourflyairline.backendairlinebookingsystem.controllers;

import com.fourflyairline.backendairlinebookingsystem.services.FlightService;
import com.fourflyairline.backendairlinebookingsystem.services.RouteService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/route")
@AllArgsConstructor
public class RouteController {
    private final RouteService routeService;

    @GetMapping("/routes")
    public ResponseEntity<?> getFlights(@RequestParam int page, @RequestParam int size){
        return ResponseEntity.ok(routeService.getRoutes(page, size));
    }
}
