package com.example.final_project.dto;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TrainDTO {

    private Integer number;

    private String StartStation;

    private LocalDateTime StartDateTime;

    private String FinishStation;

    private LocalDateTime FinishDateTime;

    private String TimeToTravel;

    private Integer NumberOfFreeSeats;

    private Integer Price;
}