package com.slandshow.controllers;

import com.slandshow.DTO.ScheduleDTO;
import com.slandshow.models.Schedule;
import com.slandshow.models.Station;
import com.slandshow.service.ScheduleService;
import com.slandshow.service.StationService;
import com.slandshow.utils.JspFormNames;
import com.slandshow.utils.UtilsManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeoutException;

@Controller
@RequestMapping("/schedule")
public class ScheduleController {

   private static final Logger LOGGER = Logger.getLogger(ScheduleController.class);

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private StationService stationService;

    @GetMapping("/scheduleList")
    public String getSchedule(Model model) {
        List<Schedule> schedules = scheduleService.getAllSchedules();
        model.addAttribute("schedules", schedules);

        return JspFormNames.SCHEDULE_INPUT_FOR_STATIONS_AND_DATE_RESULT;
    }
/*
    @GetMapping("/scheduleByStationsAndDate")
    public String getScheduleByStationsAndDate(Model model) {

        model.addAttribute("schedule", new ScheduleDTO());

        return JspFormNames.SCHEDULE_INPUT_FOR_STATIONS_AND_DATE;
    }

    // TODO: ADD JOTA TIME LATER, MAYBE DTO FOR CURRENT MAPPING
    @RequestMapping(value = "/scheduleByStationsAndDate", method = RequestMethod.POST)
    public String scheduleByStationsAndDatePersist(@ModelAttribute ScheduleDTO schedule, BindingResult result, Model model) {
        Schedule reloadedSchedule = new Schedule();

        LOGGER.info("LOADED DATA: " + schedule.getStationDepartureName() + " ," + schedule.getStationArrivalName());

        try {
            // Set <date time> and convert it to Data object
            reloadedSchedule.setDateDeparture(
                    UtilsManager.parseToDateTime(
                          schedule.getDateDeparture()
                    )
            );

            reloadedSchedule.setDateArrival(
                    UtilsManager.parseToDateTime(
                            schedule.getDateArrival()
                    )
            );

            LOGGER.info("PARSED: " + reloadedSchedule.getDateDeparture() + ", " + reloadedSchedule.getDateArrival());

        } catch (ParseException e) {
            LOGGER.debug("Problem with parsing");
        }

        /* Set stations object relation */
/*
        reloadedSchedule.setStationDeparture(
                stationService.getStationByName(schedule.getStationDepartureName())
        );

        reloadedSchedule.setStationArrival(
                stationService.getStationByName(schedule.getStationArrivalName())
        );


        LOGGER.info("STATIONS: " + reloadedSchedule.getStationDeparture() + " " + reloadedSchedule.getStationArrival());

        List<Schedule> schedules = scheduleService.getByStationsAndDate(reloadedSchedule);

        model.addAttribute("schedules", schedules);

        return JspFormNames.SCHEDULE_INPUT_FOR_STATIONS_AND_DATE_RESULT;
    }


    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_MANAGER')")
    @GetMapping("/createSchedule")
    public String createSchedule(Model model) {
        model.addAttribute("schedule", new ScheduleDTO());
        return "schedule-creation-form";
    }


     */
@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_MANAGER')")
@GetMapping("/createSchedule")
public String createSchedule(Model model) {
    model.addAttribute("scheduleCreation", new ScheduleDTO());
    return "schedule-creation-form";
}



    /**
     * add schedule
     * conditionals:
     * 1. can't add same stations in schedule
     * 2. can't add wrong times in schedule (arrival < departure)
     * 3. can't add intersection of schedules
     * 4. can't add schedule for train which placed on another station! //TODO
     * 5. can't add duplicate schedule
     * 6. can't add schedule for current day or earlier day
     *
     * @param scheduleDTO with id, date arrival/departure, stations arrival/departure, train
     * @throws
     * @throws ParseException
     */
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_MANAGER')")
    @PostMapping("/createSchedule")
    public String createSchedule(@ModelAttribute ScheduleDTO scheduleDTO) throws ParseException, IOException, TimeoutException {

        scheduleDTO.setDateDeparture(
                UtilsManager.parseInputeTokenToValid(
                        scheduleDTO.getDateDeparture()
                )
        );

        scheduleDTO.setDateArrival(
                UtilsManager.parseInputeTokenToValid(
                        scheduleDTO.getDateArrival()
                )
        );

        LOGGER.info("READY TO CREATE SCHEDULE: "
                + scheduleDTO.getStationDepartureName() + " -> "
                + scheduleDTO.getStationArrivalName() + " in time range "
                + scheduleDTO.getDateDeparture() + " to "
                + scheduleDTO.getDateArrival()
        );


        scheduleService.add(scheduleDTO);

        return "manager-menu";
    }

}
