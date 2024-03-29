package com.fourflyairline.backendairlinebookingsystem.services;

import com.fourflyairline.backendairlinebookingsystem.dto.response.FlightResponse;
import com.fourflyairline.backendairlinebookingsystem.dto.response.UserResponse;

import java.time.LocalDateTime;
import java.util.List;

public interface FlightService {
    List<FlightResponse> getFlights(int page, int size);
    List<FlightResponse> getUpcomingFlights(LocalDateTime now, Long status);
    List<FlightResponse> getFlightsByTwoDatesBetween(Long routeId, LocalDateTime departureTime, LocalDateTime arrivalTime);
    List<FlightResponse> getFlightsByDepartureTime(Long routeId, LocalDateTime departureTime);
}
