package com.fourflyairline.backendairlinebookingsystem.services;

import com.fourflyairline.backendairlinebookingsystem.model.Aircraft;

public interface AircraftService {
    Aircraft getSeatCounts(Long flightId);

}
