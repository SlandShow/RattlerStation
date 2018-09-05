package com.slandshow.service;

import com.slandshow.DTO.ScheduleDTO;
import com.slandshow.models.Schedule;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

@Service
public interface ScheduleService {

    List<Schedule> getByStationsAndDate(Schedule schedule);

    List<Schedule> getAllSchedules();

    List<ScheduleDTO> getDirectSchedulesFromDTOByStationsAndDates(ScheduleDTO scheduleDTO) throws ParseException;

    List<ScheduleDTO> getDirectSchedulesFromDTOByStations(ScheduleDTO scheduleDTO) throws ParseException;

    List<ScheduleDTO> getDirectSchedulesFromDTOByTrain(ScheduleDTO scheduleDTO) throws ParseException;

    List<ScheduleDTO> getDirectSchedulesFromDTOByDates(ScheduleDTO scheduleDTO) throws ParseException;

}
