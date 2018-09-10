package com.slandshow.DAO.Impl;

import com.slandshow.DAO.TicketDAO;
import com.slandshow.models.Schedule;
import com.slandshow.models.Seat;
import com.slandshow.models.Ticket;
import com.slandshow.models.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.Date;
import java.util.List;

@Repository
public class TicketDAOImpl<E extends Ticket> extends GenericDAOImpl<E> implements TicketDAO<E> {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Ticket> getBySchedule(Schedule schedule) {
        return sessionFactory.getCurrentSession()
                .createQuery("from Ticket where schedule = :schedule")
                .setParameter("schedule", schedule)
                .getResultList();
    }

    public List<Ticket> findSameUserOnTrain(User user, Schedule schedule) {
        return sessionFactory.getCurrentSession()
                .createQuery("from Ticket " +
                        "where schedule = :schedule and user = :user")
                .setParameter("schedule", schedule)
                .setParameter("user", user)
                .getResultList();
    }

    public Ticket findTicketByScheduleAndSeat(Schedule schedule, Seat seat) {
        return (Ticket) sessionFactory.getCurrentSession()
                .createQuery("from Ticket " +
                        "where schedule = :schedule and seat = :seat")
                .setParameter("schedule", schedule)
                .setParameter("seat", seat)
                .uniqueResult();
    }

    public List<Ticket> getByUser(User user) {
        return sessionFactory.getCurrentSession()
                .createQuery("from Ticket " +
                        "where user = :user")
                .setParameter("user", user)
                .getResultList();
    }

    public List<Ticket> getByDate(Date date) {
        return sessionFactory.getCurrentSession()
                .createQuery("from Ticket " +
                        "where date(schedule.dateDeparture) = :date")
                .setParameter("date", date)
                .getResultList();
    }

    public List<Ticket> getByDates(Date dateDeparture, Date dateArrival) {
        return sessionFactory.getCurrentSession()
                .createQuery("from Ticket " +
                        "where schedule.dateDeparture between :dateDeparture and :dateArrival " +
                        "and schedule.dateArrival between :dateDeparture and :dateArrival")
                .setParameter("dateDeparture", dateDeparture)
                .setParameter("dateArrival", dateArrival)
                .getResultList();
    }
}
