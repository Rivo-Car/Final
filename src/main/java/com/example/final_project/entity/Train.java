package com.example.final_project.entity;

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
@Entity
@Table(name="train")
public class Train {
    @Id
    @GeneratedValue (generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id", nullable = false)
    private Long Id;

    @Column(name = "number", nullable = false)
    private Integer number;

    @Column(name = "departure", nullable = false)
    private String StartStation;

    @DateTimeFormat(pattern="dd.MM.yyyy HH:mm")
    @Column(name = "date/time departure", nullable = false)
    private LocalDateTime StartDateTime;

    @Column(name = "arrival", nullable = false)
    private String FinishStation;

    @DateTimeFormat(pattern="dd.MM.yyyy HH:mm")
    @Column(name = "date/time arrival", nullable = false)
    private LocalDateTime FinishDateTime;

    @Column(name = "time to travel", nullable = false)
    private String TimeToTravel = FinishDateTime.toString();


    @Column(name = "free seats", nullable = false)
    private Integer NumberOfFreeSeats;

    @Column(name = "price", nullable = false)
    private Integer Price;
}
