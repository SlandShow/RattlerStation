package com.slandshow.controllers;

import com.slandshow.DTO.ScheduleDTO;
import com.slandshow.DTO.TrainDTO;
import com.slandshow.exceptions.ScheduleCreationException;
import com.slandshow.models.Schedule;
import com.slandshow.models.Station;
import com.slandshow.service.GraphService;
import com.slandshow.service.ScheduleService;
import com.slandshow.service.StationService;
import com.slandshow.service.TrainService;
import com.slandshow.utils.Algorithms.Graph.Graph;
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

    @GetMapping("/scheduleList")
    public String getSchedule(Model model) {
        List<Schedule> schedules = scheduleService.getAllSchedules();
        model.addAttribute("schedules", schedules);

        return JspFormNames.SCHEDULE_INPUT_FOR_STATIONS_AND_DATE_RESULT;
    }

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
    public String createSchedule(@ModelAttribute ScheduleDTO scheduleDTO, Model model) throws ParseException, IOException, TimeoutException {

        LOGGER.info("READY TO CREATE SCHEDULE: "
                + scheduleDTO.getStationDepartureName().intern() + " -> "
                + scheduleDTO.getStationArrivalName().intern() + " in time range "
                + scheduleDTO.getDateDeparture().intern() + " to "
                + scheduleDTO.getDateArrival()
        );

        String result = "";

        try {
            List<ScheduleDTO> schedulers =  scheduleService.creatingSchedulers(
                    scheduleDTO.getStationDepartureName(),
                    scheduleDTO.getStationArrivalName(),
                    scheduleDTO.getDateDeparture(),
                    null,
                    scheduleDTO.getTrainName()
            );

            scheduleService.produceMessagesToServer("[ADDING NEW SCHEDULE]");

            scheduleDTO.setDateArrival(
                   schedulers.get(schedulers.size() - 1).getDateArrival()
            );

            result = "success";

            model.addAttribute("result", result);
            model.addAttribute("scheduleInfo", scheduleDTO);

        } catch (ScheduleCreationException e) {
            e.printStackTrace();

            result = "problem";

            model.addAttribute("result", result);
            model.addAttribute("reason", e.getErrorMessage());
            model.addAttribute("scheduleInfo", scheduleDTO);
        }

        return "schedule-creation-result";
    }
}
