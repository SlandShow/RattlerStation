package com.slandshow.service.Impl;

import com.slandshow.DAO.StationDAO;
import com.slandshow.models.Station;
import com.slandshow.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class StationServiceImpl implements StationService {

    @Autowired
    public StationDAO stationDAO;

    public void setStationDAO(StationDAO stationDAO) {
        this.stationDAO = stationDAO;
    }

    @Transactional
    public List<Station> getAllStations() {
        return stationDAO.getAll();
    }

    @Transactional
    public Station getStationByName(String name) {
        return stationDAO.getByName(name);
    }
}
