package com.slandshow.service;

import com.slandshow.DTO.*;
import com.slandshow.exceptions.BookingTicketException;
import com.slandshow.exceptions.BusinessLogicException;
import com.slandshow.models.Schedule;
import com.slandshow.models.Seat;
import com.slandshow.models.Ticket;
import com.slandshow.models.User;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

@Service
public interface TicketService {

    void add(Ticket ticket);

    Ticket add(TicketDTO ticketDTO, User user) throws BookingTicketException;

    void delete(Ticket ticket);

    void update(Ticket ticket);

    List<Ticket> getAll();

    Ticket getById(Long id);

    List<Seat> getBookingSeatsBySchedule(Schedule schedule);

    boolean checkUserUntilBooking(User user, Schedule schedule);

    boolean checkSeatUntilBooking(Seat seat, Schedule schedule);

    boolean checkScheduleForAvailability(Schedule schedule) throws BookingTicketException;

    List<Ticket> getBySchedules(Schedule schedule);

    List<TicketInfoDTO> getByScheduleId(Long id);

    List<TicketInfoDTO> getAuthenticatedUserTicket();

    List<Ticket> getByDate(Date date);

    List<Ticket> getByDates(Date dateFrom, Date dateTo);

    List<List<SeatDTO>> getSeatsMatrix(int row, int col);

    List<TicketDTO> getPuzzledTickets(List<Schedule> puzzledSchedulers, int seat, int carriage);

    BookingTicketInfoDTO getBookingStatusInfo(int seat, int carriage, UserDTO userDTO);

    BookingTicketInfoDTO getBookingStatusInfo(List<TicketDTO> ticketDTOS, UserDTO userDTO);

}
