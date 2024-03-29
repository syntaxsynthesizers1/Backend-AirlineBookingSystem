package com.fourflyairline.backendairlinebookingsystem.services;
import com.fourflyairline.backendairlinebookingsystem.dto.response.RouteResponse;
import com.fourflyairline.backendairlinebookingsystem.model.Route;
import com.fourflyairline.backendairlinebookingsystem.repositories.RouteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class AirlineRouteService implements RouteService{
    private final ModelMapper modelMapper;
    private final RouteRepository routeRepository;


    @Override
    public List<RouteResponse> getRoutes(int page, int size) {
        Pageable pageable = PageRequest.of(page-1, size);
        Page<Route> routePage = routeRepository.findAll(pageable);
        List<Route> route = routePage.getContent();
        log.info("flights:: {}", route);
        return route.stream()
                .map(route1->modelMapper.map(route, RouteResponse.class))
                .toList();

    }

}
