package com.slandshow.service.Impl;

import com.slandshow.DAO.StateDAO;
import com.slandshow.DAO.TrainDAO;
import com.slandshow.DTO.TrainDTO;
import com.slandshow.DTO.TrainInfoDTO;
import com.slandshow.models.Schedule;
import com.slandshow.models.Seat;
import com.slandshow.models.State;
import com.slandshow.models.Train;
import com.slandshow.service.TrainService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class TrainServiceImpl implements TrainService {

    private static final Logger LOGGER = Logger.getLogger(TrainServiceImpl.class);

    @Autowired
    private TrainDAO trainDAO;

    @Autowired
    private StateDAO stateDAO;

    public void setTrainDAO(TrainDAO trainDAO) {
        this.trainDAO = trainDAO;
    }

    @Transactional
    public void add(TrainDTO trainDTO) {
        Train trainCreating = getByName(trainDTO.getName());

        // TODO: ADD CUSTOM EXCEPTIONS
        if (trainCreating != null) {
            throw new RuntimeException();

        }

        // TODO: ADD CUSTOM EXCEPTIONS
        if (trainDTO.getCarriageCount() < 0 || trainDTO.getCarriageCount() > 30 && trainDTO.getCarriageCount() < 0)
            throw new RuntimeException();

        Train train = new Train();
        State state = stateDAO.getByType("UNUSED");
        train.setState(state);
        train.setName(trainDTO.getName());
        Set<Seat> seats = getSeats(trainDTO.getCarriageCount(), trainDTO.getSeatsCount(), train);
        train.setSeats(seats);
        train.setCarriages(trainDTO.getCarriageCount());

        trainDAO.add(train);
        LOGGER.info("TRAIN WAS ADDED");
       // auditService.createTrainAuditInfo(train);
    }

    @Transactional
    public void delete(String name) {
        Train train = getByName(name);

        // TODO: ADD CUSTOM EXCEPTIONS
        if (train == null)
            throw new RuntimeException();

        // TODO: ADD CUSTOM EXCEPTIONS
        if (!train.getState().getType().equals("UNUSED"))
            throw new RuntimeException();

        State state = stateDAO.getByType("INVALID");
        train.setState(state);
        trainDAO.update(train);
        LOGGER.info("TRAIN WAS REMOVED");
        //auditService.deleteTrainAuditInfo(train);
    }

    @Transactional
    public void update(TrainDTO trainDTO) {
        Train train = getByName(trainDTO.getNewName());

        // TODO: ADD CUSTOM EXCEPTIONS
        if (train != null)
            throw new RuntimeException();


        train = getByName(trainDTO.getName());
        train.setName(trainDTO.getNewName());
        State state = stateDAO.getByType("UNUSED");
        train.setState(state);
        trainDAO.update(train);
        LOGGER.info("TRAIN WAS UPDATED");
        //auditService.updateTrainAuditInfo(trainDTO.getTrainName(), trainDTO.getTrainNewName());
    }

    @Transactional
    public void reestablish(String name) {
        Train train = getByName(name);
        State state = stateDAO.getByType("UNUSED");
        train.setState(state);
        trainDAO.update(train);
        //auditService.reestablishTrainAuditInfo(train);
        LOGGER.info("TRAIN WAS REESTABLISHED");
    }

    @Transactional
    public List<TrainDTO> getAll() {
        List<Train> trains = trainDAO.getAll();
        List<TrainDTO> trainDTOList = new ArrayList<>();
        trains.stream()
                .filter(train -> !train.getState().getType().equals("INVALID"))
                .forEach(train -> {
                    TrainDTO trainDTO = mapping(train);
                    trainDTOList.add(trainDTO);
                });
        return trainDTOList;
    }

    @Transactional
    public List<Train> getAllTrains() {
        return trainDAO.getAll();
    }

    @Transactional
    public List<Train> getAllValidTrains() {
        List<Train> validTrains = new ArrayList<Train>();
        List<Train> allTrains = trainDAO.getAll();

        for (int i = 0; i < allTrains.size(); i++) {
            if (allTrains.get(i).getState() != null && allTrains.get(i).getState().getType().equals("VALID"))
                validTrains.add(allTrains.get(i));
        }

        return validTrains;
    }


    @Transactional
    public Train getById(Long id) {
        return (Train) trainDAO.getById(id);
    }

    @Transactional
    public Train getByName(String name) {
        return trainDAO.getByName(name);
    }

    @Transactional
    public List<TrainInfoDTO> getLastPositionTrain() {
        List<Train> trains = trainDAO.getAll();
        List<Schedule> schedules = new ArrayList<>();
        trains.stream().forEach(train -> {
            Schedule schedule = trainDAO.getLastSchedule(train);
            if (schedule != null)
                schedules.add(schedule);
        });
        List<TrainInfoDTO> trainInfoDTOList = new ArrayList<>();
        schedules.stream().forEach(x -> {
            Random random = new Random();
            TrainInfoDTO trainDTO = new TrainInfoDTO();
            trainDTO.setName(x.getTrain().getName());
            trainDTO.setDateArrival(x.getDateArrival().toString());
            trainDTO.setDateDeparture(x.getDateDeparture().toString());
            trainDTO.setStationName(x.getStationArrival().getName());
            trainDTO.setLongitude(x.getStationArrival().getLongitude() + random.nextDouble());
            trainDTO.setLatitude(x.getStationArrival().getLatitude() + random.nextDouble());
            trainInfoDTOList.add(trainDTO);
        });
        return trainInfoDTOList;
    }

    @Transactional
    public List<TrainDTO> getAllDeletedTrains() {
        List<Train> trains = trainDAO.getAll();
        List<TrainDTO> trainDTOList = new ArrayList<>();
        trains.stream()
                .filter(train -> train.getState().getType().equals("INVALID"))
                .forEach(train -> {
                    TrainDTO trainDTO = mapping(train);
                    trainDTOList.add(trainDTO);
                });
        return trainDTOList;
    }

    @Transactional
    public List<String> getTrainsName() {
        return getAllTrains()
                .stream()
                .map(x -> x.getName())
                .collect(Collectors.toList());
    }

    public Set<Seat> getSeats(Integer cntCarriage, Integer cntSeats, Train train) {
        Set<Seat> seats = new HashSet<>();
        for (int i = 1; i <= cntCarriage; i++) {
            for (int j = 1; j <= cntSeats; j++) {
                Seat seat = new Seat();
                seat.setCarriage(i);
                seat.setSeat(j);
                seat.setTrain(train);
                seats.add(seat);
            }
        }
        return seats;
    }

    public TrainDTO mapping(Train train) {
        Set<Seat> seats = train.getSeats();
        Integer cntCarriage = Collections.max(seats.stream().map(x -> x.getCarriage()).collect(Collectors.toList()));
        Integer cntSeats = Collections.max(seats.stream().map(x -> x.getSeat()).collect(Collectors.toList()));
        TrainDTO trainDTO = new TrainDTO();
        trainDTO.setName(train.getName());
        trainDTO.setCarriageCount(cntCarriage);
        trainDTO.setSeatsCount(cntSeats);
        return trainDTO;
    }

}
