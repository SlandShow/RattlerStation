package com.slandshow.controllers;

import com.slandshow.DTO.ScheduleDTO;
import com.slandshow.DTO.StationDTO;
import com.slandshow.DTO.TrainDTO;
import com.slandshow.DTO.TrainInfoDTO;
import com.slandshow.models.Schedule;
import com.slandshow.models.Train;
import com.slandshow.service.ScheduleService;
import com.slandshow.service.SeatService;
import com.slandshow.service.TrainService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/trains")
public class TrainController {

    private static final Logger LOGGER = Logger.getLogger(TrainController.class);

    @Autowired
    private TrainService trainService;

    @Autowired
    private SeatService seatService;

    @Autowired
    private ScheduleService scheduleService;

    @GetMapping("selectTrainsByStation")
    public String selectTrainsByStation(Model model) {
        model.addAttribute("selectedStation", new StationDTO());

        return "train-selection";
    }

    @PostMapping("selectTrainsByStation")
    public String selectTrainsByStationConfirm(@ModelAttribute StationDTO station, Model model) {
        List<ScheduleDTO> schedules = scheduleService.getAll();
        List<ScheduleDTO> schedulesTrains = new ArrayList<>();

        for (ScheduleDTO current: schedules) {
            if (
                            current.getStationDepartureName().equals(station.getName()) ||
                            current.getStationArrivalName().equals(station.getName())
                    ) {
                schedulesTrains.add(current);
            }
        }

        model.addAttribute("selectedInfoSchedules", schedulesTrains);
        model.addAttribute("selectedStation", station.getName());


        return "trains-selected-by-station-list";
    }


    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_MANAGER')")
    @GetMapping("/createTrain")
    public String createTrain(Model model) {
        model.addAttribute("train", new TrainDTO());
        LOGGER.info("LOAD FORM FOR TRAIN CREATING");
        return "train-creation-form";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_MANAGER')")
    @PostMapping("/createTrain")
    public String createTrain(@ModelAttribute TrainDTO trainDTO) {
        LOGGER.info("TRAIN DATA " + trainDTO.getName() + " " + trainDTO.getCarriageCount() + " " + trainDTO.getSeatsCount());
        trainService.add(trainDTO);
        return "manager-menu";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_MANAGER')")
    @GetMapping("/deleteTrain")
    public String deleteTrain(Model model) {
        model.addAttribute("trainList", trainService.getAll());
        LOGGER.info("VIEW ALL TRAINS");
        return "trains-list";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_MANAGER')")
    @RequestMapping(value = "/deleteTrain", params = "name")
    public String deleteTrain(@ModelAttribute TrainDTO trainDTO,  @RequestParam(value = "name") String name) {
        trainService.delete(name);
        LOGGER.info("READY TO DELETE TRAIN" + trainDTO.getName() + " " + trainDTO.getCarriageCount() + " " + trainDTO.getSeatsCount());
        return "manager-menu";
    }

}
