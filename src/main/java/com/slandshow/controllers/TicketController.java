package com.slandshow.controllers;

import com.slandshow.DTO.*;
import com.slandshow.exceptions.BookingTicketException;
import com.slandshow.models.Schedule;
import com.slandshow.models.Seat;
import com.slandshow.models.Ticket;
import com.slandshow.models.Train;
import com.slandshow.service.*;
import com.slandshow.utils.JspFormNames;
import com.slandshow.utils.UtilsManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("tickets")
public class TicketController {

    private static final Logger LOGGER = Logger.getLogger(TicketController.class);

    @Autowired
    private TicketService ticketService;

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private TrainService trainService;

    @Autowired
    private GraphService graphService;

    @GetMapping("/buyTicket")
    public String buyTicket(Model model) {
        model.addAttribute("schedule", new ScheduleDTO());
        return JspFormNames.SCHEDULE_INPUT_FOR_STATIONS_AND_DATE;
    }


    @PostMapping("/buyTicket")
    public String scheduleByStationsAndDatePersist(@ModelAttribute ScheduleDTO schedule, HttpSession session, Model model) {
        Schedule reloadedSchedule = null;

        LOGGER.info(
                "LOADED DATA: " + schedule.getStationDepartureName() + ", "
                + schedule.getStationArrivalName() + ", "
                + schedule.getDateDeparture() + ", "
                + schedule.getDateArrival()
        );

        graphService.buildGraph();

        List<ScheduleDTO> schedulers = null;

        try {

            List<Schedule> list =  graphService.puzzleSchedules(
                    graphService.parsePath(
                            graphService.searchEdges(schedule.getStationDepartureName().intern(), schedule.getStationArrivalName().intern())
                    ),
                    schedule.getDateDeparture().intern(),
                    schedule.getDateArrival().intern()
            );

            LOGGER.info("SEARCHED INFO VIA GRAPH: " + list);


            Map<ScheduleDTO, List<Schedule>> map = graphService.filter(list);
            for (Map.Entry<ScheduleDTO, List<Schedule>> entry : map.entrySet()) {
                LOGGER.info("SELECTED PUZZLED SCHEDULER:" + entry.getKey().getTrainName() + ":" + entry.getValue().toString());
            }

            // Add map to session
            session.setAttribute("map", map);

            schedulers = graphService.parsedListFromMap(map);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (schedulers != null)
            model.addAttribute("schedules", schedulers);


        return JspFormNames.BOOKING_TICKET_LIST;
    }

    @RequestMapping(value = "/viewTicketsTrainInfo", params = {"train", "start", "end"})
    public String confirmBooking(Model model, HttpSession session, @RequestParam(value = "train") String train, @RequestParam(value = "start") String start,  @RequestParam(value = "end") String end) {

        // Get map with all puzzled schedulers from session
        Map<ScheduleDTO, List<Schedule>> map = (Map<ScheduleDTO, List<Schedule>>) session.getAttribute("map");

        // Select value from map - list of picked schedulers (using params in URL)
        List<Schedule> puzzledSchedulers = map.get(
                new ScheduleDTO(train)
        );

        // Get reserved seats
        List<Seat> listOfReservedSeats = ticketService.getBookingSeatsBySchedule(puzzledSchedulers.get(0));

        LOGGER.info(
                "RESERVED SEATS IN CURRENT TRAIN # "
                        + train
                        + " IS..."
        );

        for (Seat currentSeat: listOfReservedSeats) {
            LOGGER.info(
                    "SEAT # "
                            + currentSeat.getSeat()
                            + " IN CARRIAGE #"
                            + currentSeat.getCarriage()
                            + " IS RESERVED"
            );
        }

        // Move list to next controller via session
        session.setAttribute("puzzledSchedulers", puzzledSchedulers);

        // For rendering
        model.addAttribute(
                "carriages",
                   ticketService.getSeatsMatrix(
                           puzzledSchedulers.get(0).getTrain().getCarriages(),
                           puzzledSchedulers.get(0).getTrain().getSeats().size() / puzzledSchedulers.get(0).getTrain().getCarriages()
                   )
        );

        return "train-seats-booking-info";
    }

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/confirmBooking", params = {"seat", "carriage"})
    public String confirmBooking(HttpSession session, @RequestParam(value = "seat") Integer seat, @RequestParam(value = "carriage") Integer carriage, Model model) {

        // Status for booking result
        String status = "";

        // Create puzzled tickets
        List<TicketDTO> ticketDTOS = ticketService.getPuzzledTickets(
                (List<Schedule>) session.getAttribute("puzzledSchedulers"),
                seat,
                carriage
        );

        // Authenticated user object
        UserDTO userDTO = userService.findAuthenticatedUserDTO();

        try {
            // Iterate each element of puzzled ticketDTO's and reserve it to user
            for (int i = 0; i < ticketDTOS.size(); i++)
                ticketService.add(
                        ticketDTOS.get(i),
                        userService.findUserByEmail(userDTO.getLogin())
                );


            model.addAttribute(
                      "ticketInfo",
                         ticketService.getBookingStatusInfo(ticketDTOS, userDTO)
            );

            status = "success";

        } catch (BookingTicketException e) {

            // Create model attribute info status for booking problems
            model.addAttribute(
                    "ticketInfo",
                       ticketService.getBookingStatusInfo(seat, carriage, userDTO)
            );

            // Create model attribute - String (reason of booking problem)
            model.addAttribute("reason", e.getErrorMessage());

            // Change status
            status = "problem";
        }

        model.addAttribute("message", status);

        return JspFormNames.BOOKING_TICKET_FORM_RESULT;
    }

}
