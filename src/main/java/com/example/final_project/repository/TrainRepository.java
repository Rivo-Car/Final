package com.example.final_project.repository;

import com.example.final_project.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TrainRepository extends JpaRepository<Train, Long> {
    @Query(value = "SELECT * from train", nativeQuery = true)
    List<Train> findAll();

    @Query(value = "SELECT * from train where departure = :departure and arrival = :arrival", nativeQuery = true)
    List<Train> findTrainsByStartStationAndFinishStation(@Param("departure") String Departure, @Param("arrival")String Arrival);


}
