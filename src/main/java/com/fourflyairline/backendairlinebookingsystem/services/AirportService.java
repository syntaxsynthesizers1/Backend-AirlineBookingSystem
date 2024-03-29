package com.fourflyairline.backendairlinebookingsystem.services;

import com.fourflyairline.backendairlinebookingsystem.dto.response.AirportsResponse;
import com.fourflyairline.backendairlinebookingsystem.dto.response.FlightResponse;

import java.util.List;

public interface AirportService {
    List<AirportsResponse> getAirports(int page, int size);
}
