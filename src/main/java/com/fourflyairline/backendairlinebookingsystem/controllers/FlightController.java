package com.fourflyairline.backendairlinebookingsystem.controllers;

import com.fourflyairline.backendairlinebookingsystem.services.FlightService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;


@RestController
@RequestMapping("/api/v1/flight")
@AllArgsConstructor
public class FlightController {
    private final FlightService flightService;

    @GetMapping
    public ResponseEntity<?> getFlights(@RequestParam int page, @RequestParam int size){
        return ResponseEntity.ok(flightService.getFlights(page, size));
    }
    @GetMapping("/getFlights")
    public ResponseEntity<?> getUpcomingFlights(@RequestParam LocalDateTime now,  @RequestParam Long status){
        return ResponseEntity.ok(flightService.getUpcomingFlights(now, status));
    }


    @GetMapping("/viewFlights")
    public ResponseEntity<?> getFlightsByDapartureTime(@RequestParam Long routeId, @RequestParam LocalDateTime departureTime){
        return ResponseEntity.ok(flightService.getFlightsByDepartureTime(routeId, departureTime));
    }
    @GetMapping("/upComingFlights")
    public ResponseEntity<?> getFlightsByTwoDates(@RequestParam Long routeId, @RequestParam LocalDateTime departureTime,
                                                  @RequestParam LocalDateTime arrivalTime){
        return ResponseEntity.ok(flightService.getFlightsByTwoDatesBetween(routeId, departureTime, arrivalTime));
    }

}
