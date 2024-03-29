package com.fourflyairline.backendairlinebookingsystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Setter
@Getter
public class Flights {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
