package com.slandshow.DAO;

import com.slandshow.DAO.GenericDAO;
import com.slandshow.models.Schedule;
import com.slandshow.models.Seat;
import com.slandshow.models.Ticket;
import com.slandshow.models.User;
import org.springframework.stereotype.Repository;
import java.util.Date;
import java.util.List;

@Repository
public interface TicketDAO<E extends Ticket> extends GenericDAO<E> {

    List<Ticket> getBySchedule(Schedule schedule);

    List<Ticket> findSameUserOnTrain(User user, Schedule schedule);

    Ticket findTicketByScheduleAndSeat(Schedule schedule, Seat seat);

    List<Ticket> getByUser(User user);

    List<Ticket> getByDate(Date date);

    List<Ticket> getByDates(Date dateDeparture, Date dateArrival);
}