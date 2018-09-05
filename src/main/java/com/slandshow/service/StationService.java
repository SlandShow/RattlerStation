package com.slandshow.service;


import com.slandshow.models.Station;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StationService {

   List<Station> getAllStations();

   Station getStationByName(String name);
}
