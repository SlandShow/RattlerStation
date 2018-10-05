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

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

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
    public String scheduleByStationsAndDatePersist(@ModelAttribute ScheduleDTO schedule, BindingResult result, Model model) {
        Schedule reloadedSchedule = null;

        LOGGER.info(
                "LOADED DATA: " + schedule.getStationDepartureName() + ", "
                + schedule.getStationArrivalName() + ", "
                + schedule.getDateDeparture() + ", "
                + schedule.getDateArrival()
        );

        graphService.buildGraph();


        try {
            LOGGER.info("SEARCHED INFO VIA GRAPH: "
                    + graphService.puzzleSchedules(
                        graphService.parsePath(
                                graphService.searchEdges(schedule.getStationDepartureName().intern(), schedule.getStationArrivalName().intern())
                        ),
                        schedule.getDateDeparture().intern(),
                        schedule.getDateArrival().intern()
                    )
            );
        } catch (ParseException e) {
            e.printStackTrace();
        }


        try {
            reloadedSchedule = scheduleService.mapping(schedule);

            LOGGER.info("PARSED: Dates is "
                    + reloadedSchedule.getDateDeparture() + ", "
                    + reloadedSchedule.getDateArrival() + "\n Stations is "
                    + reloadedSchedule.getStationDeparture() + ", "
                    + reloadedSchedule.getStationArrival()
            );

        } catch (ParseException e) {
            LOGGER.debug("Problem with parsing");
        }

        List<Schedule> schedules = null;

        if (reloadedSchedule.getDateArrival() == null)
            schedules = scheduleService.getByStationsAndDate(reloadedSchedule);
        else schedules = scheduleService.getByStationsAndDates(reloadedSchedule);

        model.addAttribute("schedules", schedules);

        return JspFormNames.BOOKING_TICKET_LIST;
    }


    /*
    @Autowired
    private TrainService trainService;
    @GetMapping("/test")
    public String test(Model model) {
        Train selected = trainService.getByName("Train#138");
        List<List<SeatDTO>> carriages = new ArrayList<List<SeatDTO>>();

        int seatsCount = 1;

        for (int carriagesIterator = 1; carriagesIterator <= selected.getCarriages(); carriagesIterator++) {
            ArrayList<SeatDTO> seats = new ArrayList<SeatDTO>();
            for (int seatsIterator = 1; seatsIterator <= (selected.getSeats().size() / selected.getCarriages()); seatsIterator++) {
                seats.add(new SeatDTO(carriagesIterator, seatsCount++));
            }

            carriages.add(seats);
        }

        model.addAttribute("carriages", carriages);
        Schedule selectedSchedule = scheduleService.getById(1l);
        model.addAttribute("selectedSchedule", selectedSchedule);

        return "train-seats-booking-info";
    }
*/



    @RequestMapping(value = "/viewTicketsTrainInfo", params = "id")
    public String confirmBooking(@RequestParam(value = "id") Long id, Model model) {
        Schedule selectedSchedule = scheduleService.getById(id);
        //TicketInfoDTO ticketInfoDTO = (TicketInfoDTO) request.getSession().getAttribute("ticketDTO");
        List<List<SeatDTO>> carriages = new ArrayList<List<SeatDTO>>();

        LOGGER.info(
                "RESERVED SEATS IN CURRENT TRAIN # "
                + selectedSchedule.getTrain().getName()
                + " IS..."
        );


        List<Seat> listOfReservedSeats = ticketService.getBookingSeatsBySchedule(selectedSchedule);

        for (Seat currentSeat: listOfReservedSeats) {
            LOGGER.info(
                            "SEAT # "
                            + currentSeat.getSeat()
                            + " IN CARRIAGE #"
                            + currentSeat.getCarriage()
                            + " IS RESERVED"
            );
        }


        // Create matrix of seats per carriage
        // TODO: ADD THIS LEGACY CODE BESIDE CONTROLLER
        int seatsCount = 1;
        int row = selectedSchedule.getTrain().getCarriages();
        int col = selectedSchedule.getTrain().getSeats().size() / selectedSchedule.getTrain().getCarriages();

        for (int carriagesIterator = 1; carriagesIterator <= row; carriagesIterator++) {
            ArrayList<SeatDTO> seats = new ArrayList<SeatDTO>();
            seatsCount = 1;
            for (int seatsIterator = 1; seatsIterator <= col; seatsIterator++) {
                seats.add(new SeatDTO(carriagesIterator, seatsCount++));
            }

            carriages.add(seats);
        }

        model.addAttribute("selectedSchedule", selectedSchedule);
        model.addAttribute("carriages", carriages);

        return "train-seats-booking-info";
    }

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/confirmBooking", params = {"seat", "carriage", "scheduleId"})
    public String confirmBooking(@RequestParam(value = "seat") Integer seat, @RequestParam(value = "carriage") Integer carriage,  @RequestParam(value = "scheduleId") Long scheduleId, Model model) {

        TicketDTO ticketDTO = new TicketDTO();
        ticketDTO.setScheduleId(scheduleId);

        SeatDTO seatDTO = new SeatDTO();
        seatDTO.setSeat(seat);
        seatDTO.setCarriage(carriage);
        ticketDTO.setSeatDTO(seatDTO);

        UserDTO userDTO = userService.findAuthenticatedUserDTO();

        LOGGER.info("LOADED USER TRY TI BUY " + userDTO.getLogin());
        LOGGER.info(ticketDTO.getScheduleId() + " ; " + ticketDTO.getSeatDTO().getCarriage() + " " + ticketDTO.getSeatDTO().getSeat());

        String result = "";

        try {
            ticketService.add(
                    ticketDTO,
                    userService.findUserByEmail(userDTO.getLogin())
            );

            BookingTicketInfoDTO ticketInfoDTO = new BookingTicketInfoDTO();
            ticketInfoDTO.setSeatNumber(seatDTO.getSeat());
            ticketInfoDTO.setCarriageNumber(seatDTO.getCarriage());

            ticketInfoDTO.setStationDepartureName(
                    scheduleService.getById(ticketDTO.getScheduleId()).getStationDeparture().getName()
            );

            ticketInfoDTO.setStationArrivalName(
                    scheduleService.getById(ticketDTO.getScheduleId()).getStationArrival().getName()
            );

            ticketInfoDTO.setDateDeparture(
                    scheduleService.getById(ticketDTO.getScheduleId()).getDateDeparture()
            );

            ticketInfoDTO.setDateArrival(
                    scheduleService.getById(ticketDTO.getScheduleId()).getDateArrival()
            );

            ticketInfoDTO.setUser(
                            userDTO.getFirstName() + " "
                            + userDTO.getLastName() + " ("
                            + userDTO.getLogin() + ")"
            );

            model.addAttribute("ticketInfo", ticketInfoDTO);

            result = "success";
        } catch (BookingTicketException e) {
            e.printStackTrace();

            BookingTicketInfoDTO ticketInfoDTO = new BookingTicketInfoDTO();
            ticketInfoDTO.setSeatNumber(seatDTO.getSeat());
            ticketInfoDTO.setCarriageNumber(seatDTO.getCarriage());

            ticketInfoDTO.setUser(
                    userDTO.getFirstName() + " "
                            + userDTO.getLastName() + " ("
                            + userDTO.getLogin() + ")"
            );


            model.addAttribute("ticketInfo", ticketInfoDTO);
            model.addAttribute("reason", e.getErrorMessage());

            result = "problem";
        }

        model.addAttribute("message", result);


        return JspFormNames.BOOKING_TICKET_FORM_RESULT;
    }


    /*


    /*
    @PostMapping("/buyTicket")
    public String confirmTicketBooking(@ModelAttribute TicketInfoDTO ticketInfoDTO, HttpServletRequest request, Model model) {
        Schedule schedule = new Schedule();

        if (
                ticketInfoDTO.getScheduleStationDepartureName() == null ||
                        ticketInfoDTO.getScheduleStationArrivalName() == null ||
                        ticketInfoDTO.getScheduleStationDepartureName() == null ||
                        ticketInfoDTO.getUserLogin() == null ||
                        ticketInfoDTO.getSeatCarriage() < 0 ||
                        ticketInfoDTO.getSeatSeat() < 0
                ) {
            LOGGER.info("NOT VALID INPUT!");
            return JspFormNames.BOOKING_TICKET_FORM;
        }

        schedule.setStationDeparture(
                stationService.getStationByName(ticketInfoDTO.getScheduleStationDepartureName())
        );

        schedule.setStationArrival(
                stationService.getStationByName(ticketInfoDTO.getScheduleStationArrivalName())
        );

        try {
            schedule.setDateDeparture(
                    UtilsManager.parseToDateTime(ticketInfoDTO.getScheduleDateDeparture())
            );
        } catch (ParseException e) {
            e.printStackTrace();
        }

        TicketInfoDTO parsedTicketInfo = new TicketInfoDTO();
        parsedTicketInfo.setUserLogin(ticketInfoDTO.getUserLogin());
        parsedTicketInfo.setSeatSeat(ticketInfoDTO.getSeatSeat());
        parsedTicketInfo.setSeatCarriage(ticketInfoDTO.getSeatCarriage());

        request.getSession().setAttribute("ticketDTO", parsedTicketInfo);
        model.addAttribute("schedules", scheduleService.getByStationsAndDate(schedule));

        return JspFormNames.BOOKING_TICKET_LIST;
    }

   */

}
