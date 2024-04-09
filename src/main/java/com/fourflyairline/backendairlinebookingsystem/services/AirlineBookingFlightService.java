package com.fourflyairline.backendairlinebookingsystem.services;


import com.fourflyairline.backendairlinebookingsystem.dto.response.FlightResponse;
import com.fourflyairline.backendairlinebookingsystem.dto.response.UserResponse;
import com.fourflyairline.backendairlinebookingsystem.exceptions.AirlineBookingSystemException;
import com.fourflyairline.backendairlinebookingsystem.model.Flights;
import com.fourflyairline.backendairlinebookingsystem.model.User;
import com.fourflyairline.backendairlinebookingsystem.repositories.FlightsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class AirlineBookingFlightService implements FlightService{
    private final FlightsRepository flightsRepository;
    private final ModelMapper modelMapper;



    @Override
    public List<FlightResponse> getFlights(int page, int size) {
        Pageable pageable = PageRequest.of(page-1, size);
        Page<Flights> flightsPage = flightsRepository.findAll(pageable);
        List<Flights> flights = flightsPage.getContent();
        log.info("flights:: {}", flights);
        return flights.stream()
                .map(flight->modelMapper.map(flights, FlightResponse.class))
                .toList();

    }
    public List<FlightResponse> getUpcomingFlights(LocalDateTime now, Long status) {
           List<Flights> flightsPage = flightsRepository.findTop6ByDepartureTimeAfterAndFlightStatusIdOrderByDepartureTime(now, status);
            log.info("flights:: {}", flightsPage);
            return flightsPage.stream()
                    .map(flight->modelMapper.map(flight, FlightResponse.class))
                    .toList();

        }

    @Override
    public Flights getFlightById(Long id) throws AirlineBookingSystemException {
        return flightsRepository.findById(id).orElseThrow(
                ()-> new AirlineBookingSystemException(String.format("flight with id %d not found", id))
        );
    }
    @Override
    public FlightResponse getFlightBy(Long id) throws AirlineBookingSystemException {
        Flights flights = getFlightById(id);
        return modelMapper.map(flights, FlightResponse.class);
    }






    @Override
    public List<FlightResponse> getFlightsByDepartureTime(Long routeId, LocalDateTime departureTime) {
        List<Flights> flightsPage = flightsRepository.findByRouteIdAndDepartureTime(routeId, departureTime);
        log.info("flights:: {}", flightsPage);
        return flightsPage.stream()
                .map(flight->modelMapper.map(flight, FlightResponse.class))
                .toList();

    }

    @Override
    public List<FlightResponse> getFlightsByTwoDatesBetween(Long routeId, LocalDateTime departureTime, LocalDateTime arrivalTime) {
        List<Flights> flightsPage = flightsRepository.findByRouteIdAndDepartureTimeBetween(routeId, departureTime, arrivalTime) ;
        log.info("flights:: {}", flightsPage);
        return flightsPage.stream()
                .map(flight->modelMapper.map(flight, FlightResponse.class))
                .toList();

    }





}
