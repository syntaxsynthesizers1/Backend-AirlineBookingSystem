package com.fourflyairline.backendairlinebookingsystem.services;

import com.fourflyairline.backendairlinebookingsystem.model.Aircraft;
import com.fourflyairline.backendairlinebookingsystem.repositories.AircraftRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AirlineBookingAircraftService implements AircraftService{

    private final AircraftRepository aircraftRepository;


    @Override
    public Aircraft getSeatCounts(Long flightId) {
        return aircraftRepository.findSeatCountsByFlightId(flightId);
    }
}
