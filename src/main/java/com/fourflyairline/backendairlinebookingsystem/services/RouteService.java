package com.fourflyairline.backendairlinebookingsystem.services;

import com.fourflyairline.backendairlinebookingsystem.dto.response.FlightResponse;
import com.fourflyairline.backendairlinebookingsystem.dto.response.RouteResponse;

import java.util.List;

public interface RouteService {

    List<RouteResponse> getRoutes(int page, int size);
}
