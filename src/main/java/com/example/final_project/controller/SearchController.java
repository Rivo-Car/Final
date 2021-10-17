package com.example.final_project.controller;

import org.springframework.data.jdbc.repository.query.Query;

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
        log.info("Search page opened");
        model.addAttribute("list", service.getAllRoutes());

        return "search/searchpage";
    }

    @GetMapping("/search/search")
    public String search(Model model, String Departure, String Arrival) {
        model.addAttribute("list",
                service.findAllByStartStationAndFinishDateTime(Departure, Arrival));
        model.addAttribute("departure", Departure);
        model.addAttribute("arrival", Arrival);
        log.info("fuck you");
        return "search/searchpage";
    }
}
