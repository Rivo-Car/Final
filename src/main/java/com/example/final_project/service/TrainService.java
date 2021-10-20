package com.example.final_project.service;

import com.example.final_project.dto.*;
import com.example.final_project.entity.*;
import com.example.final_project.repository.*;
import com.example.final_project.util.Mapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class TrainService {
    @Autowired
    private final TrainRepository trainRepository;

    public TrainService(TrainRepository trainRepository) {
        this.trainRepository = trainRepository;
    }

    public void saveNewRoute (Train train) {
        try {
            Train savedTrain = !trainRepository.findAll().contains(train) ?
                    trainRepository.save(train) : null;
            log.info("Saved train:" + savedTrain.toString());
        } catch (Exception e) {
            log.info(e.getMessage());
        }
    }

    public List<TrainDTO> getAllRoutes(){
        try{
            return trainRepository.findAll().stream()
                    .map(Mapper::TrainToTrainDTO)
                    .toList();
        }catch(Exception e){
            log.info("Trains not found");
            throw e;
        }
    }

    public List<TrainDTO> findTrainsByStartStationAndFinishStation(String Departure, String Arrival) {
        List<Train> foundList = trainRepository
                .findTrainsByStartStationAndFinishStation(Departure, Arrival);
        if (!foundList.isEmpty()) {
            return foundList.stream()
                    .map(Mapper::TrainToTrainDTO)
                    .toList();
        }
        return trainRepository.findAll().stream()
                .map(Mapper::TrainToTrainDTO)
                .toList();
    }
}
