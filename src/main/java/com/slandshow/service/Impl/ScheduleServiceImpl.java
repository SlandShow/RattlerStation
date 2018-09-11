package com.slandshow.service.Impl;

import com.slandshow.DAO.ScheduleDAO;
import com.slandshow.DTO.ScheduleDTO;
import com.slandshow.models.Schedule;
import com.slandshow.models.Station;
import com.slandshow.models.Train;
import com.slandshow.service.ScheduleService;
import com.slandshow.service.StationService;
import com.slandshow.service.TicketService;
import com.slandshow.service.TrainService;
import com.slandshow.utils.UtilsManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    private static final Logger LOGGER = Logger.getLogger(ScheduleServiceImpl.class);

    @Autowired
    private ScheduleDAO scheduleDAO;

    //@Autowired
   // private StationService stationService;

    //@Autowired
   // private TrainService trainService;

    @Autowired
    private TicketService ticketService;

    //@Autowired
   // private DistanceService distanceService;


    /**
     * TODO: FIX
     * create schedule (check intersection of times and correctness of times)
     *
     * @param scheduleDTO
     */

    @Transactional
    public void add(ScheduleDTO scheduleDTO) throws ParseException, IOException, TimeoutException {
        /*Train train = trainService.getByName(scheduleDTO.getTrainName());
        Station stationArrival = stationService.getByName(scheduleDTO.getStationArrivalName());
        Station stationDeparture = stationService.getByName(scheduleDTO.getStationDepartureName());

        if (stationArrival == null || stationDeparture == null || train == null)
            throw new BusinessLogicException(ErrorCode.NULL_ELEMENTS.getMessage());

        Date dateDeparture = Utils.parseToDateTime(scheduleDTO.getDateDeparture());

        Date dateArrival;
        if (scheduleDTO.getDateArrival().isEmpty())
            dateArrival = distanceService.calculateDateArrival(dateDeparture, stationDeparture, stationArrival);
        else dateArrival = Utils.parseToDateTime(scheduleDTO.getDateArrival());

        Schedule schedule = new Schedule();
        schedule.setStationDeparture(stationDeparture);
        schedule.setStationArrival(stationArrival);
        schedule.setDateDeparture(dateDeparture);
        schedule.setDateArrival(dateArrival);
        schedule.setTrain(train);


        if (stationArrival.equals(stationDeparture))
            throw new BusinessLogicException(ErrorCode.SAME_STATIONS.getMessage());

        if (!dateDeparture.before(dateArrival))
            throw new BusinessLogicException(ErrorCode.WRONG_DATES.getMessage());

        if (!getByDateAndTrainToCheckIntersection(schedule).isEmpty())
            throw new BusinessLogicException(ErrorCode.INTERSECTION_SCHEDULES.getMessage());

        if (Utils.checkCurrentDay(dateDeparture))
            throw new BusinessLogicException(ErrorCode.SCHEDULE_FOR_CURRENT_DAY.getMessage());

        Status status = statusDAO.getByName("WORKED");
        schedule.getStationDeparture().setStatus(status);
        schedule.getStationArrival().setStatus(status);
        schedule.getTrain().setStatus(status);

        scheduleDAO.add(schedule);
        auditService.createScheduleAuditInfo(schedule);
        messageQueueService.produceMsg("create id=" + schedule.getId());
        log.info("SCHEDULE WAS CREATED!");*/
    }

    @Transactional
    public void delete(Long id) throws IOException, TimeoutException {
        Schedule schedule = getById(id);

        // TODO: FIX THIS STUFF
        if (!ticketService.getBySchedules(schedule).isEmpty()) {
            LOGGER.debug("PROBLEM WITH DELETING SCHEDULE!");
            throw new IOException();
        }

        scheduleDAO.delete(schedule);
    }

    // TODO: FIX THIS FUNCTIONALITY LATER
    @Transactional
    public void update(ScheduleDTO scheduleDTO) throws ParseException, IOException, TimeoutException {
        /*Schedule schedule = getById(scheduleDTO.getId());
        Schedule scheduleOld = schedule;
        if (!ticketService.getBySchedules(schedule).isEmpty())
            throw new IOException();

        Train train = trainService.getByName(scheduleDTO.getTrainName());
        Station stationDeparture = stationService.getByName(scheduleDTO.getStationDepartureName());
        Station stationArrival = stationService.getByName(scheduleDTO.getStationArrivalName());

        if (train == null || stationDeparture == null || stationArrival == null)
            throw new BusinessLogicException(ErrorCode.NULL_ELEMENTS.getMessage());

        Date dateDeparture = Utils.parseToDateTime(scheduleDTO.getDateDeparture());
        Date dateArrival = Utils.parseToDateTime(scheduleDTO.getDateArrival());

        train.setName(scheduleDTO.getTrainName());
        stationDeparture.setName(scheduleDTO.getStationDepartureName());
        stationArrival.setName(scheduleDTO.getStationArrivalName());
        schedule.setTrain(train);
        schedule.setStationDeparture(stationDeparture);
        schedule.setStationArrival(stationArrival);
        schedule.setDateDeparture(dateDeparture);
        schedule.setDateArrival(dateArrival);

        if (stationDeparture.equals(stationArrival))
            throw new BusinessLogicException(ErrorCode.SAME_STATIONS.getMessage());

        if (!dateDeparture.before(dateArrival))
            throw new BusinessLogicException(ErrorCode.WRONG_DATES.getMessage());

        if (getByDateAndTrainToCheckIntersection(schedule).size() > 1)
            throw new BusinessLogicException(ErrorCode.INTERSECTION_SCHEDULES.getMessage());

        if (Utils.checkCurrentDay(dateDeparture))
            throw new BusinessLogicException(ErrorCode.SCHEDULE_FOR_CURRENT_DAY.getMessage());

        scheduleDAO.update(schedule);
        auditService.updateScheduleAuditInfo(scheduleOld, schedule);
        messageQueueService.produceMsg("update id=" + schedule.getId());*/
    }

    // TODO: FIX LATER
    @Transactional
    public List<ScheduleDTO> getAll() {
        /*
        List<Schedule> schedules = scheduleDAO.getAll();
        return schedules.stream()
                .map(x -> modelMapper.map(x, ScheduleDTO.class))
                .collect(Collectors.toList());
                */
        return null;
    }


    @Override
    public List<ScheduleDTO> getAllForToday() throws ParseException {
        return null;
    }

    @Transactional
    public Schedule getById(Long id) {
        return (Schedule) scheduleDAO.getById(id);
    }

    @Transactional
    public List<Schedule> getByDate(Date dateDeparture) {
        return scheduleDAO.getByDate(dateDeparture);
    }

    @Transactional
    public List<Schedule> getByDates(Date dateDeparture, Date dateArrival) throws ParseException {
        dateArrival = UtilsManager.getNextDay(dateArrival);
        if (dateArrival.before(dateDeparture)) {
            LOGGER.info("INCORRECT DATA, CANT RETURN SCHEDULE BY DATES!");
        }

        return scheduleDAO.getByDates(dateDeparture, dateArrival);
    }

    @Transactional
    public List<Schedule> getByStationsAndDate(Schedule schedule) {
        return scheduleDAO.getByStationsAndDate(schedule);
    }

    @Transactional
    public List<Schedule> getByDateAndTrainToCheckIntersection(Schedule schedule) {
        return scheduleDAO.getByDateAndTrainToCheckIntersection(schedule);
    }

    @Transactional
    public List<Schedule> getByTrainAndDate(Schedule schedule) {
        return scheduleDAO.getByTrainAndDate(schedule);
    }

    @Transactional
    public List<Schedule> getByStationArrivalAndDate(Schedule schedule) {
        return scheduleDAO.getByStationArrivalAndDate(schedule);
    }

    @Transactional
    public List<ScheduleDTO> getDirectSchedulesFromDTOByStationsAndDatesAndTrain(ScheduleDTO scheduleDTO) throws ParseException {
        return null;
    }

    @Transactional
    public List<Schedule> getAllSchedules() {
        return scheduleDAO.getAll();
    }

    @Transactional
    public List<ScheduleDTO> getDirectSchedulesFromDTOByStationsAndDates(ScheduleDTO scheduleDTO) throws ParseException {
        return null;
    }

    @Transactional
    public List<ScheduleDTO> getDirectSchedulesFromDTOByStations(ScheduleDTO scheduleDTO) throws ParseException {
        return null;
    }

    public List<ScheduleDTO> getDirectSchedulesFromDTOByTrain(ScheduleDTO scheduleDTO) throws ParseException {
        return null;
    }

    public List<ScheduleDTO> getDirectSchedulesFromDTOByDates(ScheduleDTO scheduleDTO) throws ParseException {
        return null;
    }

    @Transactional
    public List<Schedule> getByStationArrivalAndDates(Station station, Date dateFrom, Date dateTo) {
        return scheduleDAO.getByStationArrivalAndDates(station, dateFrom, dateTo);
    }

    @Override
    public ScheduleDTO getByIdScheduleDTO(Long id) {
        return null;
    }
}
