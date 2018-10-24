package com.slandshow.controllers;

import com.slandshow.DTO.StationDTO;
import com.slandshow.DTO.TrainDTO;
import com.slandshow.exceptions.InvalidStationException;
import com.slandshow.models.Station;
import com.slandshow.service.StationService;
import com.slandshow.utils.JspFormNames;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/stations")
public class StationController {

    @Autowired
    private StationService stationService;

    private static final Logger LOGGER = Logger.getLogger(StationController.class);

    @RequestMapping("/list")
    public String getStations(Model model) {

        List<Station> stations = stationService.getAllStations();

        model.addAttribute("stations", stations);

        return JspFormNames.STATIONS_VIEW_LIST;
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_MANAGER')")
    @GetMapping("/createStation")
    public String createTrain(Model model) {
        model.addAttribute("stationCreation", new StationDTO());
        LOGGER.info("LOAD FORM FOR STATION CREATING");
        return "station-creation-form";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_MANAGER')")
    @PostMapping("/createStation")
    public String createTrain(@ModelAttribute StationDTO stationDTO) {
        LOGGER.info("STATION DATA " + stationDTO.getName() + " " + stationDTO.getLatitude() + " " + stationDTO.getLongitude());
        try {
            stationService.add(stationDTO);
        } catch (InvalidStationException e) {
            e.printStackTrace();
        }
        return "manager-menu";
    }

}
