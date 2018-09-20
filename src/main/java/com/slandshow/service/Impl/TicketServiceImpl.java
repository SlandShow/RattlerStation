package com.slandshow.service.Impl;

import com.slandshow.DAO.TicketDAO;
import com.slandshow.DTO.TicketDTO;
import com.slandshow.DTO.TicketInfoDTO;
import com.slandshow.models.*;
import com.slandshow.service.*;
import com.slandshow.utils.UtilsManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketServiceImpl implements TicketService {

    private static final Logger LOGGER = Logger.getLogger(TicketServiceImpl.class);

    @Autowired
    private TicketDAO ticketDAO;

    @Autowired
    private SeatService seatService;

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private DistanceAndPriceUtilsService distanceService;

    @Autowired
    private SecureService secureService;

    @Autowired
    private UserService userService;

    @Transactional
    public void add(Ticket ticket) {
        ticketDAO.add(ticket);
    }

    /*
     * Booking ticket
     *
     * Before we buy ticket, we must check:
     * 1) Correct schedule
     * 2) Unique person
     * 3) Free seats
     * 4) Before start more than 10 minutes
     *
     */

    @Transactional
    public Ticket add(TicketDTO ticketDTO, User user) throws IOException, ParseException {
        Schedule schedule = scheduleService.getById(ticketDTO.getScheduleId());

        // TODO: ADD NEW EXCEPTION CLASS AND FIX THIS
        if (schedule == null || user == null)
            throw new IOException();

        // TODO: ADD NEW EXCEPTION CLASS AND FIX THIS
        if (!checkUserUntilBooking(user, schedule))
            throw new IOException();

        // TODO: ADD NEW EXCEPTION CLASS AND FIX THIS
        if (!checkScheduleForAvailability(schedule))
            throw new IOException();

        Train train = schedule.getTrain();
        LOGGER.info("TICKET SERVICE: TRAIN IS " + train +
                " CARRIAGE IS " + ticketDTO.getSeatDTO().getCarriage() +
                " SEAT IS " + ticketDTO.getSeatDTO().getSeat()
        );

        Seat seat = seatService.getByTrainAndCarriageAndSeat(
                train,
                ticketDTO.getSeatDTO().getCarriage(),
                ticketDTO.getSeatDTO().getSeat()
        );

        LOGGER.info("SEAT DETECTED: " + seat);

        // TODO: ADD NEW EXCEPTION CLASS AND FIX THIS
        if (seat == null || !checkSeatUntilBooking(seat, schedule))
            throw new IOException();

        Ticket ticket = new Ticket();
        ticket.setSchedule(schedule);
        ticket.setSeat(seat);
        ticket.setUser(user);

        // TODO: ADD LATER CALCULATION OF PRICE
        //ticket.setPrice();

        // Add ticket in DB
        add(ticket);

        LOGGER.info("TICKED RESERVED!");

        return null;
    }

    @Transactional
    public void delete(Ticket ticket) {
        ticketDAO.delete(ticket);
    }

    @Transactional
    public void update(Ticket ticket) {
        ticketDAO.update(ticket);
    }

    @Transactional
    public List<Ticket> getAll() {
        return ticketDAO.getAll();
    }

    @Transactional
    public Ticket getById(Long id) {
        return (Ticket) ticketDAO.getById(id);
    }

    /* Return reserved seats */
    @Transactional
    public List<Seat> getBookingSeatsBySchedule(Schedule schedule) {
        List<Ticket> tickets = ticketDAO.getBySchedule(schedule);
        List<Seat> bookingSeats = new ArrayList<>();
        for (Ticket ticket :
                tickets) {
            bookingSeats.add(ticket.getSeat());
        }
        return bookingSeats;
    }

    /* Check if user already have ticket */
    @Transactional
    public boolean checkUserUntilBooking(User user, Schedule schedule) {
        return ticketDAO.findSameUserOnTrain(user, schedule).isEmpty();
    }

    /* Check if we have correct schedule */
    @Transactional
    public boolean checkSeatUntilBooking(Seat seat, Schedule schedule) {
        return ticketDAO.findTicketByScheduleAndSeat(schedule, seat) == null;
    }

    /* Check if we can buy ticket in time & data case */
    @Transactional
    public boolean checkScheduleForAvailability(Schedule schedule) throws ParseException {
        Date date = schedule.getDateDeparture();
        return UtilsManager.checkForCurrentDayForBookingTicket(date);
    }

    @Transactional
    public List<Ticket> getBySchedules(Schedule schedule) {
        return ticketDAO.getBySchedule(schedule);
    }

    // TODO: FIX LATER
    @Transactional
    public List<TicketInfoDTO> getByScheduleId(Long id) {
        return null;
    }

    // TODO: FIX LATER
    @Transactional
    public List<TicketInfoDTO> getAuthenticatedUserTicket() {
        return null;
    }

    @Transactional
    public List<Ticket> getByDate(Date date) {
        return ticketDAO.getByDate(date);
    }

    @Transactional
    public List<Ticket> getByDates(Date dateFrom, Date dateTo) {
        return ticketDAO.getByDates(dateFrom, dateTo);
    }
}
