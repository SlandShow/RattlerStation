package com.slandshow.service;


import com.slandshow.DTO.StationDTO;
import com.slandshow.models.Station;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StationService {

   Station getStationByName(String name);

   void add(StationDTO stationDTO);

   void delete(String name);

   void update(StationDTO stationDTO);

   void reestablish(String name);

   List<StationDTO> getAll();

   List<Station> getAllStations();

   List<StationDTO> getAllDeletedStations();

   Station getById(Long id);

   Station getByName(String name);

   List<String> getStationsName();
}
