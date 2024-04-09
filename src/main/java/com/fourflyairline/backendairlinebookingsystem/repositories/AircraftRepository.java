package com.fourflyairline.backendairlinebookingsystem.repositories;

import com.fourflyairline.backendairlinebookingsystem.model.Aircraft;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AircraftRepository extends JpaRepository<Aircraft, Long> {
    @Query("SELECT a.economySeatCapacity, a.businessSeatCapacity, a.platinumSeatCapacity FROM Aircraft a WHERE a.id = ?1")
    Aircraft findSeatCountsByFlightId(Long flightId);

}
