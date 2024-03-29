package com.fourflyairline.backendairlinebookingsystem.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
public class FlightResponse {
    private Long airplaneId;
    private Long routeId;
    private Long flightStatusId;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private String flightNo;
    private Double economyFare;
    private Double businessFare;
    private Double platinumFare;

}
