package com.slandshow.service.Impl;

import com.slandshow.DAO.ScheduleDAO;
import com.slandshow.models.Schedule;
import com.slandshow.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleDAO scheduleDAO;

    @Transactional
    public List<Schedule> getByStationsAndDate(Schedule schedule) {
        return scheduleDAO.getByStationsAndDate(schedule);
    }

    @Transactional
    public List<Schedule> getAllSchedules() {
        return scheduleDAO.getAll();
    }
}
