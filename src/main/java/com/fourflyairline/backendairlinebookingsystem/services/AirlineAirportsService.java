package com.fourflyairline.backendairlinebookingsystem.services;

import com.fourflyairline.backendairlinebookingsystem.dto.response.AirportsResponse;
import com.fourflyairline.backendairlinebookingsystem.dto.response.FlightResponse;
import com.fourflyairline.backendairlinebookingsystem.model.Airport;
import com.fourflyairline.backendairlinebookingsystem.model.Flights;
import com.fourflyairline.backendairlinebookingsystem.repositories.AirportRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class AirlineAirportsService implements AirportService{
    private final AirportRepository airportRepository;
    private final ModelMapper modelMapper;


    @Override
    public List<AirportsResponse> getAirports(int page, int size) {
        Pageable pageable = PageRequest.of(page-1, size);
        Page<Airport> airportsPage = airportRepository.findAll(pageable);
        List<Airport> airports = airportsPage.getContent();
        log.info("flights:: {}", airports);
        return airports.stream()
                .map(airport->modelMapper.map(airport, AirportsResponse.class))
                .toList();

    }
}
