package com.example.final_project.service;

import com.example.final_project.entity.*;
import com.example.final_project.dto.*;
import com.example.final_project.util.*;
import lombok.Getter;
import com.example.final_project.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

@Slf4j
@Service
public class RouteService {
    @Autowired
    private final RouteRepository routeRepository;

    public RouteService(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    public void saveNewRoute (Route route) {
        try {
            Route savedRoute = !routeRepository.findAll().contains(route) ?
                    routeRepository.save(route) : null;
            log.info("Saved" + savedRoute.getFinishStation().toString());
        } catch (Exception e) {
            log.info(e.getMessage());
        }
    }

    public List<RouteDTO> getAllRoutes(){
            try{
                return routeRepository.findAll().stream()
                        .map(Mapper::RouteToRouteDTO)
                        .toList();
            }catch(Exception e){
                log.info("Routes not found");
                throw e;
            }
    }


    public void deleteRoute(Route route){
        routeRepository.delete(route);
    }

    public List<RouteDTO> findRoutesByStartStationAndFinishStation(String Departure, String Arrival) {
        List<Route> foundList = routeRepository
                .findRoutesByStartStationAndFinishStation(Departure, Arrival);
        if (!foundList.isEmpty()) {
            return foundList.stream()
                    .map(Mapper::RouteToRouteDTO)
                    .toList();
        }
        return routeRepository.findAll().stream()
                .map(Mapper::RouteToRouteDTO)
                .toList();
    }
}