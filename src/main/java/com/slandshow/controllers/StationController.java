package com.slandshow.controllers;

import com.slandshow.models.Station;
import com.slandshow.service.StationService;
import com.slandshow.utils.JspFormNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/stations")
public class StationController {

    @Autowired
    private StationService stationService;

    @RequestMapping("/list")
    public String getStations(Model model) {

        List<Station> stations = stationService.getAllStations();

        model.addAttribute("stations", stations);

        return JspFormNames.STATIONS_VIEW_LIST;
    }
}
