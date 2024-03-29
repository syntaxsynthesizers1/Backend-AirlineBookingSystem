package com.fourflyairline.backendairlinebookingsystem.repositories;

import com.fourflyairline.backendairlinebookingsystem.model.Airplane;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirplaneRepository extends JpaRepository<Airplane, Long> {
}
