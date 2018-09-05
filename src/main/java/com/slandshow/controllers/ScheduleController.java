package com.slandshow.controllers;

import com.slandshow.DTO.ScheduleDTO;
import com.slandshow.models.Schedule;
import com.slandshow.models.Station;
import com.slandshow.service.ScheduleService;
import com.slandshow.service.StationService;
import com.slandshow.utils.JspFormNames;
import com.slandshow.utils.UtilsManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller()
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

    @GetMapping("/scheduleByStationsAndDate")
    public String getScheduleByStationsAndDate(Model model) {

        model.addAttribute("schedule", new ScheduleDTO());

        return JspFormNames.SCHEDULE_INPUT_FOR_STATIONS_AND_DATE;
    }

    // TODO: ADD JOTA TIME LATER, MAYBE DTO FOR CURRENT MAPPING
    @RequestMapping(value = "/scheduleByStationsAndDate", method = RequestMethod.POST)
    public String scheduleByStationsAndDatePersist(@ModelAttribute ScheduleDTO schedule, BindingResult result, Model model) {
        Schedule reloadedSchedule = new Schedule();

        try {
            // Set <date time> and convert it to Data object
            reloadedSchedule.setDateDeparture(
                    UtilsManager.parseToDateTime(schedule.getDateDeparture())
            );

        } catch (ParseException e) {
            LOGGER.debug("Problem with parsing");
        }

        /* Set stations object relation */

        reloadedSchedule.setStationDeparture(
                stationService.getStationByName(schedule.getStationDepartureName())
        );

        reloadedSchedule.setStationArrival(
                stationService.getStationByName(schedule.getStationArrivalName())
        );


        LOGGER.debug(reloadedSchedule.getStationDeparture() + " " + reloadedSchedule.getStationArrival());

        List<Schedule> schedules = scheduleService.getByStationsAndDate(reloadedSchedule);

        model.addAttribute("schedules", schedules);

        return JspFormNames.SCHEDULE_INPUT_FOR_STATIONS_AND_DATE_RESULT;
    }

}
