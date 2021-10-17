package com.example.final_project.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.*;
import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="route")
public class Route {
    @Id
    @GeneratedValue (generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id", nullable = false)
    private Long Id;

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

    public static boolean equals(Route route1, Route route2) {
        return route1.getStartStation().equals(route2.getStartStation())&&
                route1.getFinishDateTime().isEqual(route2.getFinishDateTime())&&
                route1.getFinishStation().equals(route2.getFinishStation())&&
                route1.getStartDateTime().isEqual(route2.getStartDateTime());
    }
}
