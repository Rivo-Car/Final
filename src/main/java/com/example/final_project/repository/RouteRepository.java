package com.example.final_project.repository;

import com.example.final_project.dto.RouteDTO;
import com.example.final_project.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import  java.util.List;

public interface RouteRepository extends JpaRepository<Route, Long> {
    @Query(value = "SELECT * from route", nativeQuery = true)
    List<Route> findAll();

    @Query(value = "SELECT * from route where departure = :departure and arrival = :arrival", nativeQuery = true)
    List<Route> findRoutesByStartStationAndFinishStation(@Param("departure") String Departure, @Param("arrival")String Arrival);


}