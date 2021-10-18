package com.example.final_project.controller;

import com.example.final_project.service.RouteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
public class SearchController {

    @Autowired
    private RouteService service;

    @GetMapping("/search")
    String searchEngine(Model model){
        log.info("Search page opened" + service.getAllRoutes().get(0).getFinishStation());
        model.addAttribute("list", service.getAllRoutes());

        return "search/search";
    }

    @GetMapping("/search/search")
    public String search(Model model, String departure, String arrival) {
        log.info(arrival + departure);
        model.addAttribute("list",
        service.findRoutesByStartStationAndFinishStation(departure, arrival));

        log.info("fuck you ");
        return  "search/search";
    }
}
