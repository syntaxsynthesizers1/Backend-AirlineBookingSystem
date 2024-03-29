package com.fourflyairline.backendairlinebookingsystem.repositories;

import com.fourflyairline.backendairlinebookingsystem.model.Aircraft;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AircraftRepository extends JpaRepository<Aircraft, Long> {
}
