package com.fourflyairline.backendairlinebookingsystem.services;

import com.fourflyairline.backendairlinebookingsystem.dto.response.FlightResponse;
import com.fourflyairline.backendairlinebookingsystem.dto.response.UserResponse;
import com.fourflyairline.backendairlinebookingsystem.exceptions.AirlineBookingSystemException;
import com.fourflyairline.backendairlinebookingsystem.model.Flights;
import com.fourflyairline.backendairlinebookingsystem.model.User;

import java.time.LocalDateTime;
import java.util.List;

public interface FlightService {
    List<FlightResponse> getFlights(int page, int size);
    FlightResponse getFlightBy(Long id) throws AirlineBookingSystemException;
    Flights getFlightById(Long id) throws AirlineBookingSystemException;
    List<FlightResponse> getUpcomingFlights(LocalDateTime now, Long status);
    List<FlightResponse> getFlightsByTwoDatesBetween(Long routeId, LocalDateTime departureTime, LocalDateTime arrivalTime);
    List<FlightResponse> getFlightsByDepartureTime(Long routeId, LocalDateTime departureTime);
}
