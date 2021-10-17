package com.example.final_project.util;

import  com.example.final_project.entity.*;
import com.example.final_project.dto.*;

public class Mapper {
    //TODO Builders
    public static Route RouteDTOToRoute(RouteDTO routeDTO){
        Route route = new Route();
        route.setId(routeDTO.getId());
        route.setStartStation(routeDTO.getStartStation());
        route.setStartDateTime(routeDTO.getStartDateTime());
        route.setFinishDateTime(routeDTO.getFinishDateTime());
        route.setFinishStation(routeDTO.getFinishStation());
        return route;
    }

    public static RouteDTO RouteToRouteDTO(Route route){
        RouteDTO routeDTO = new RouteDTO();
        routeDTO.setId(route.getId());
        routeDTO.setStartStation(route.getStartStation());
        routeDTO.setStartDateTime(route.getStartDateTime());
        routeDTO.setFinishDateTime(route.getFinishDateTime());
        routeDTO.setFinishStation(route.getFinishStation());
        return routeDTO;
    }

}
