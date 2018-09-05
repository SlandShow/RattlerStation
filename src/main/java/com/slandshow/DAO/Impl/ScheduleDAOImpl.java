package com.slandshow.DAO.Impl;

import com.slandshow.DAO.ScheduleDAO;
import com.slandshow.models.Schedule;
import com.slandshow.models.Station;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

@Repository
public class ScheduleDAOImpl<E extends Schedule> extends GenericDAOImpl<E> implements ScheduleDAO<E> {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /*
     * Return list of schedule according on departure date
     *
     * @param date
     * @return schedule of date (list)
     */
    public List<Schedule> getByDate(Date date) {
        return sessionFactory.getCurrentSession()
                .createQuery("from Schedule " +
                        "where date(dateDeparture) = :date " +
                        "order by dateDeparture desc ")
                .setParameter("date", date)
                .getResultList();
    }

    /*
     * Return list of schedule according on departure and arrival date
     *
     * @param dateDeparture
     * @param dareArrival
     * @return schedule of of date (list)
     */
    public List<Schedule> getByDates(Date dateDeparture, Date dateArrival) {
        return sessionFactory.getCurrentSession()
                .createQuery("from Schedule " +
                        "where dateDeparture between :dateDeparture and :dateArrival " +
                        "and dateArrival between :dateDeparture and :dateArrival " +
                        "order by id desc ")
                .setParameter("dateDeparture", dateDeparture)
                .setParameter("dateArrival", dateArrival)
                .getResultList();
    }

    /*
     * Return list of schedule according on stations and date
     *
     * @param schedule
     * @return all schedule by arrival and departure stations and date
     */
    public List<Schedule> getByStationsAndDate(Schedule schedule) {
        return sessionFactory.getCurrentSession()
                .createQuery("from Schedule where " +
                        "stationArrival = :stationArrival and " +
                        "stationDeparture = :stationDeparture and " +
                        "date(dateDeparture) = :date " +
                        "order by dateDeparture desc ")
                .setParameter("stationArrival", schedule.getStationArrival())
                .setParameter("stationDeparture", schedule.getStationDeparture())
                .setParameter("date", schedule.getDateDeparture())
                .getResultList();
    }


    /*
     * Return list of schedule according on stations and date (departure & arrival)
     *
     * @param schedule
     * @return all schedule by arrival and departure stations and date departure & arrival
     */
    public List<Schedule> getByStationsAndDates(Schedule schedule) {
        String QUERY = "from Schedule s where s.stationDeparture = :stationDeparture and s.stationArrival = :stationArrival and date(dateDeparture) = :date order by dateDeparture desc";

        return sessionFactory.getCurrentSession()
                .createQuery(QUERY)
                .setParameter("stationArrival", schedule.getStationArrival())
                .setParameter("stationDeparture", schedule.getStationDeparture())
                .setParameter("date", schedule.getDateDeparture())
                .getResultList();
    }

    public List<Schedule> getByDateAndTrainToCheckIntersection(Schedule schedule) {
        return null;
    }

    public List<Schedule> getByTrainAndDate(Schedule schedule) {
        return null;
    }

    public List<Schedule> getByTrainAndDates(Schedule schedule) {
        return null;
    }

    public List<Schedule> getByStationArrivalAndDate(Schedule schedule) {
        return null;
    }

    public List<Schedule> getByStationsAndDatesAndTrains(Schedule schedule) {
        return null;
    }

    public List<Schedule> getByStationArrivalAndDates(Station station, Date dateFrom, Date dateTo) {
        return null;
    }

    public List<Schedule> getRealTimeSchedules() throws ParseException {
        return null;
    }

    public List<Schedule> getForToday() throws ParseException {
        return null;
    }
}
