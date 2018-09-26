package com.slandshow.controllers;

import com.slandshow.models.Schedule;
import com.slandshow.models.Ticket;
import com.slandshow.models.Train;
import com.slandshow.service.ScheduleService;
import com.slandshow.service.TicketService;
import com.slandshow.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("managerToolsService")
public class ManagerController {

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private TrainService trainService;

    @Autowired
    private TicketService ticketService;



    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_MANAGER')")
    @GetMapping("/viewBookingTrains")
    public String viewBookingTrains(Model model) {
        //List<TrainDTO> bookingTrains = trainService.getAll();
        List<Train> bookingTrains = trainService.getAllValidTrains();
        model.addAttribute("bookingTrains", bookingTrains);

        return "booking-train-users-list";
    }


   // @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_MANAGER')")
   @RequestMapping("/viewSelectedSchedules/{trainId}")
   public  String viewBookingTrains(@PathVariable(value="trainId") Long trainId, Model model) {
       List<Schedule> selectedScheduleByTrain = scheduleService.getByTrain(
               trainService.getById(trainId)
       );

       System.out.println(selectedScheduleByTrain);

       model.addAttribute("selectedSchedulesByTrain", selectedScheduleByTrain);

       return "schedule-list";
   }

    //@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_MANAGER')")
    @RequestMapping("/viewBookingUsersInfo/{scheduleId}")
    public String viewBookingUsersInfo(@PathVariable(value = "scheduleId") Long scheduleId, Model model) {
        // List<Seat> bookingSeats = ticketService.getBookingSeatsBySchedule(
        //  scheduleService.getById(scheduleId)
        // );

        List<Ticket> tickets = ticketService.getBySchedules(
                scheduleService.getById(scheduleId)
        );


        model.addAttribute("tickets", tickets);

        return "booking-users-in-train";
    }







}
