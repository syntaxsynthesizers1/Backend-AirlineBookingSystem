package com.fourflyairline.backendairlinebookingsystem.repositories;

import com.fourflyairline.backendairlinebookingsystem.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteRepository extends JpaRepository<Route, Long> {
}
