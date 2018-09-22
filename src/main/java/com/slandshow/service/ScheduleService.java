package com.slandshow.service;

import com.slandshow.DTO.ScheduleDTO;
import com.slandshow.DTO.SeatsDTO;
import com.slandshow.models.Schedule;
import com.slandshow.models.Station;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeoutException;

@Service
public interface ScheduleService {

    void add(ScheduleDTO scheduleDTO) throws ParseException, IOException, TimeoutException;

    void delete(Long id) throws IOException, TimeoutException;

    void update(ScheduleDTO scheduleDTO) throws ParseException, IOException, TimeoutException;

    List<Schedule> getAllSchedules();

    List<ScheduleDTO> getAll();

    List<ScheduleDTO> getAllForToday() throws ParseException;

    Schedule getById(Long id);

    List<Schedule> getByDate(Date dateDeparture);

    List<Schedule> getByDates(Date dateDeparture, Date dateArrival) throws ParseException;

    List<Schedule> getByStationsAndDate(Schedule schedule);

    List<Schedule> getByDateAndTrainToCheckIntersection(Schedule schedule);

    List<Schedule> getByTrainAndDate(Schedule schedule);

    List<Schedule> getByStationsAndDates(Schedule schedule);

    List<Schedule> getByStationArrivalAndDate(Schedule schedule);

    //List<TransferScheduleDTO> getTransferSchedules(ScheduleDTO scheduleDTO) throws ParseException, BusinessLogicException;

    List<ScheduleDTO> getDirectSchedulesFromDTOByStationsAndDatesAndTrain(ScheduleDTO scheduleDTO) throws ParseException;

    List<ScheduleDTO> getDirectSchedulesFromDTOByStations(ScheduleDTO scheduleDTO) throws ParseException;

    List<ScheduleDTO> getDirectSchedulesFromDTOByTrain(ScheduleDTO scheduleDTO) throws ParseException;

    List<ScheduleDTO> getDirectSchedulesFromDTOByDates(ScheduleDTO scheduleDTO) throws ParseException;

    SeatsDTO getSeats(Long id);

    List<Schedule> getByStationArrivalAndDates(Station station, Date dateFrom, Date dateTo);

    //List<ScheduleMapDTO> getByRealTimeSchedules() throws ParseException;

    ScheduleDTO getByIdScheduleDTO(Long id);

    Schedule mapping(ScheduleDTO scheduleDTO) throws ParseException;
}
