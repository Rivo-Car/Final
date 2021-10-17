package com.example.final_project.repository;

import com.example.final_project.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import  java.util.List;

public interface RouteRepository extends JpaRepository<Route, Long> {
    @Query(value = "SELECT * from route", nativeQuery = true)
    List<Route> findAll();

    @Query(value = "SELECT * from route where departure = ?1 and arrival = ?2", nativeQuery = true)
    List<Route> findAllByStartStationAndFinishDateTime(String Departure, String Arrival);


}