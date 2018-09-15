package com.slandshow.service.Impl;

import com.slandshow.DAO.StateDAO;
import com.slandshow.DAO.StationDAO;
import com.slandshow.DTO.StationDTO;
import com.slandshow.models.State;
import com.slandshow.models.Station;
import com.slandshow.service.StationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StationServiceImpl implements StationService {

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
    public void add(StationDTO stationDTO) {
        Station stationCreating = getByName(stationDTO.getName());

        // TODO: ADD CUSTOM EXCEPTIONS
        if (stationCreating != null)
            throw new RuntimeException();

        Station station = new Station();
        station.setName(stationDTO.getName());
        station.setLatitude(stationDTO.getLatitude());
        station.setLongitude(stationDTO.getLongitude());
        State state = stateDAO.getByType("UNUSED");
        station.setState(state);
        stationDAO.add(station);
        //auditService.createStationAuditInfo(station);
    }

    @Transactional
    public void delete(String name) {
        Station station = getByName(name);

        // TODO: ADD CUSTOM EXCEPTIONS
        if (station == null)
            throw new RuntimeException();

        // TODO: ADD CUSTOM EXCEPTIONS
        if (!station.getState().getType().equals("UNUSED"))
            throw new RuntimeException();


        State state = stateDAO.getByType("INVALID");
        station.setState(state);
        stationDAO.update(station);
       //auditService.deleteStationAuditInfo(station);
    }

    @Transactional
    public void update(StationDTO stationDTO) {
        Station station = getByName(stationDTO.getNewName());

        // TODO: ADD CUSTOM EXCEPTIONS
        if (station != null)
            throw new RuntimeException();

        station = getByName(stationDTO.getName());
        station.setName(stationDTO.getNewName());
        State state = stateDAO.getByType("UNUSED");
        station.setState(state);
        stationDAO.update(station);
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
