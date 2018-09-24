package com.slandshow.DAO;

import com.slandshow.models.Schedule;
import com.slandshow.models.Station;
import com.slandshow.models.Train;
import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

@Repository
public interface ScheduleDAO<E extends Schedule> extends GenericDAO<E> {

    List<Schedule> getByDate(Date date);

    List<Schedule> getByDates(Date dateDeparture, Date dateArrival);

    List<Schedule> getByStationsAndDate(Schedule schedule);

    List<Schedule> getByStationsAndDates(Schedule schedule);

    List<Schedule> getByDateAndTrainToCheckIntersection(Schedule schedule);

    List<Schedule> getByTrain(Train train);

    List<Schedule> getByTrainAndDate(Schedule schedule);

    List<Schedule> getByTrainAndDates(Schedule schedule);

    List<Schedule> getByStationArrivalAndDate(Schedule schedule);

    List<Schedule> getByStationsAndDatesAndTrains(Schedule schedule);

    List<Schedule> getByStationArrivalAndDates(Station station, Date dateFrom, Date dateTo);

    List<Schedule> getRealTimeSchedules() throws ParseException;

    List<Schedule> getForToday() throws ParseException;
}
