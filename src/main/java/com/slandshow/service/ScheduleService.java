package com.slandshow.service;

import com.slandshow.models.Schedule;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ScheduleService {

    List<Schedule> getByStationsAndDate(Schedule schedule);

    List<Schedule> getAllSchedules();
}
