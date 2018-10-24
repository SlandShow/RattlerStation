package com.slandshow.service.Impl;

import com.slandshow.DAO.StateDAO;
import com.slandshow.DAO.StationDAO;
import com.slandshow.DTO.StationDTO;
import com.slandshow.exceptions.ExceptionsInfo;
import com.slandshow.exceptions.InvalidStationException;
import com.slandshow.models.State;
import com.slandshow.models.Station;
import com.slandshow.service.StationService;
import org.apache.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StationServiceImpl implements StationService {

    private static final Logger LOGGER = Logger.getLogger(Thread.State.class);

    @Autowired
    public StationDAO stationDAO;

    @Autowired
    private StateDAO stateDAO;

    public void setStationDAO(StationDAO stationDAO) {
        this.stationDAO = stationDAO;
    }

    @Transactional
    public List<Station> getAllStations() {
        return stationDAO.getAll();
    }

    @Transactional
    public List<StationDTO> getAllDeletedStations() {
        ModelMapper modelMapper = new ModelMapper();
        List<Station> stations = stationDAO.getAll();
        return stations.stream().filter(x -> x.getState().getType().equals("INVALID"))
                .map(x -> modelMapper.map(x, StationDTO.class)).collect(Collectors.toList());
    }

    @Transactional
    public Station getById(Long id) {
        return (Station) stationDAO.getById(id);
    }

    @Transactional
    public Station getByName(String name) {
        return stationDAO.getByName(name);
    }

    @Transactional
    public List<String> getStationsName() {
        return getAllStations()
                .stream()
                .map(x -> x.getName())
                .collect(Collectors.toList());
    }

    @Transactional
    public Station getStationByName(String name) {
        return stationDAO.getByName(name);
    }

    @Transactional
    public void add(StationDTO stationDTO) throws InvalidStationException {
        Station stationCreating = getByName(stationDTO.getName());

        if (stationCreating != null) {
            LOGGER.info(ExceptionsInfo.STATION_IS_NOT_UNIQUE);
            throw new InvalidStationException(ExceptionsInfo.STATION_IS_NOT_UNIQUE);
        }

        Station station = new Station();
        station.setName(stationDTO.getName());
        station.setLatitude(stationDTO.getLatitude());
        station.setLongitude(stationDTO.getLongitude());
        State state = stateDAO.getByType("UNUSED");
        station.setState(state);
        stationDAO.add(station);
        LOGGER.info("STATION " + station.getName() + " WAS ADDED (BUT UNUSED NOW)");
        //auditService.createStationAuditInfo(station);
    }

    @Transactional
    public void delete(String name) throws InvalidStationException {
        Station station = getByName(name);

        if (station == null) {
            LOGGER.info(ExceptionsInfo.STATION_IS_NULL);
            throw new InvalidStationException(ExceptionsInfo.STATION_IS_NULL);
        }

        if (!station.getState().getType().equals("UNUSED")) {
            LOGGER.info(ExceptionsInfo.STATION_IS_UNUSED);
            throw new InvalidStationException(ExceptionsInfo.STATION_IS_UNUSED);
        }

        State state = stateDAO.getByType("INVALID");
        station.setState(state);
        stationDAO.update(station);
        LOGGER.info("STATION " + station.getName() + " WAS DELETED (INVALID)");
       //auditService.deleteStationAuditInfo(station);
    }

    @Transactional
    public void update(StationDTO stationDTO) throws InvalidStationException {
        Station station = getByName(stationDTO.getNewName());

        if (station != null) {
            LOGGER.info(ExceptionsInfo.STATION_IS_NULL);
            throw new InvalidStationException(ExceptionsInfo.STATION_IS_NULL);
        }

        station = getByName(stationDTO.getName());
        station.setName(stationDTO.getNewName());
        State state = stateDAO.getByType("UNUSED");
        station.setState(state);
        stationDAO.update(station);
        LOGGER.info("STATION WAS UPDATED " + stationDTO.getName() + " -> " + stationDTO.getNewName());
        //auditService.updateStationAuditInfo(stationDTO.getName(), stationDTO.getNewName());
    }

    @Transactional
    public void reestablish(String name) {
        Station station = getByName(name);
        State state = stateDAO.getByType("UNUSED");
        station.setState(state);
        stationDAO.update(station);
        //auditService.reestablishStationAuditInfo(station);
    }

    @Transactional
    public List<StationDTO> getAll() {
        ModelMapper modelMapper = new ModelMapper();
        List<Station> stations = stationDAO.getAll();
        return stations.stream().filter(x -> !x.getState().getType().equals("INVALID"))
                .map(x -> modelMapper.map(x, StationDTO.class)).collect(Collectors.toList());
    }
}
