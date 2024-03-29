package com.fourflyairline.backendairlinebookingsystem.repositories;

import com.fourflyairline.backendairlinebookingsystem.model.Flights;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface FlightsRepository extends JpaRepository<Flights, Long> {
    List<Flights> findTop6ByDepartureTimeAfterAndFlightStatusIdOrderByDepartureTime(LocalDateTime now, Long status);
    List<Flights> findByRouteIdAndDepartureTimeBetween(Long routeId, LocalDateTime departDate, LocalDateTime returnDate);
    List<Flights> findByRouteIdAndDepartureTime(Long routeId, LocalDateTime departDate);
}
