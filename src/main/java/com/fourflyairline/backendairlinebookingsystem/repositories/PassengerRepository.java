package com.fourflyairline.backendairlinebookingsystem.repositories;

import com.fourflyairline.backendairlinebookingsystem.model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {
}
