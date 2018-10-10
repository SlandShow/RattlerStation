package com.slandshow.controllers;

import com.slandshow.DTO.ScheduleDTO;
import com.slandshow.DTO.StationDTO;
import com.slandshow.service.ScheduleService;
import com.slandshow.service.StationService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

/*
 *
 * REST API for boarding schedules
 *
 */

@RestController
public class BoardScheduleController {

    private static final Logger LOGGER = Logger.getLogger(BoardScheduleController.class);

    @Autowired
    ScheduleService scheduleService;

    @Autowired
    StationService stationService;

    @GetMapping("/api/board/schedule/today")
    public ResponseEntity<?> getSchedulesForToday() {
        List<ScheduleDTO> schedules = null;
        try {
            schedules = scheduleService.getAllForToday();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        LOGGER.info("RETRIEVED " + schedules.size() + " RECORDS");
        return ResponseEntity.ok(schedules);
    }

    @GetMapping("/api/board/stations")
    public ResponseEntity<?> getStationList() {
        List<StationDTO> stations = stationService.getAll();
        LOGGER.info("RETRIEVED " + stations.size() + " RECORDS");
        return ResponseEntity.ok(stations);
    }

}
