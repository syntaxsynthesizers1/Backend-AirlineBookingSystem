package com.fourflyairline.backendairlinebookingsystem.controllers;

import com.fourflyairline.backendairlinebookingsystem.exceptions.AirlineBookingSystemException;
import com.fourflyairline.backendairlinebookingsystem.services.FlightService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;


@RestController
@RequestMapping("/api/v1/flight")
@AllArgsConstructor
public class FlightController {
    private final FlightService flightService;


    @GetMapping("{id}")
    public ResponseEntity<?> getFlight(@PathVariable Long id)  {
        try {
            return ResponseEntity.ok(flightService.getFlightBy(id));
        }catch (AirlineBookingSystemException exception){
            return ResponseEntity.badRequest().body(exception);
        }
    }

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
