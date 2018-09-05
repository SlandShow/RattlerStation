package com.slandshow.controllers;

import com.slandshow.models.Schedule;
import com.slandshow.models.Station;
import com.slandshow.service.ScheduleService;
import com.slandshow.service.StationService;
import com.slandshow.utils.JspFormNames;
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

        model.addAttribute("schedule", new Schedule());

        return JspFormNames.SCHEDULE_INPUT_FOR_STATIONS_AND_DATE;
    }

    // TODO: ADD JOTA TIME LATER, MAYBE DTO FOR CURRENT MAPPING
    @RequestMapping(value = "/scheduleByStationsAndDate", method = RequestMethod.POST)
    public String scheduleByStationsAndDatePersist(@ModelAttribute Schedule schedule, BindingResult result, Model model) {
        Date today = new Date();


        if (schedule.getDateDeparture() == null)
            schedule.setDateDeparture(today);



        schedule.setStationDeparture(
                stationService.getStationByName(
                        schedule.getStationDeparture().getName()
                )
        );
        schedule.setStationArrival(
                stationService.getStationByName(
                        schedule.getStationArrival().getName())
        );

        LOGGER.debug(schedule.getStationDeparture() + " " + schedule.getStationArrival());

        List<Schedule> schedules = scheduleService.getByStationsAndDate(schedule);

        model.addAttribute("schedules", schedules);

        return JspFormNames.SCHEDULE_INPUT_FOR_STATIONS_AND_DATE_RESULT;
    }

}
