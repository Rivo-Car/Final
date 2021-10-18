package com.example.final_project.util;

import  com.example.final_project.entity.*;
import com.example.final_project.dto.*;
import lombok.Builder;

@Builder
public class Mapper {
    //TODO Builders
    public static Route RouteDTOToRoute(RouteDTO routeDTO){
        return Route.builder()
                .Id(routeDTO.getId())
                .StartStation(routeDTO.getStartStation())
                .StartDateTime(routeDTO.getStartDateTime())
                .FinishStation(routeDTO.getFinishStation())
                .FinishDateTime(routeDTO.getFinishDateTime())
                .build();
    }

    public static RouteDTO RouteToRouteDTO(Route route){
        return RouteDTO.builder()
                .Id(route.getId())
                .StartStation(route.getStartStation())
                .StartDateTime(route.getStartDateTime())
                .FinishStation(route.getFinishStation())
                .FinishDateTime(route.getFinishDateTime())
                .build();
    }

}
