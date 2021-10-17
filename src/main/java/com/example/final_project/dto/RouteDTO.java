package com.example.final_project.dto;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RouteDTO {

    @Id
    private Long Id;

    private String StartStation;

    @DateTimeFormat(pattern="dd.MM.yyyy HH:mm")
    private LocalDateTime StartDateTime;

    private String FinishStation;

    @DateTimeFormat(pattern="dd.MM.yyyy HH:mm")
    private LocalDateTime FinishDateTime;
}
