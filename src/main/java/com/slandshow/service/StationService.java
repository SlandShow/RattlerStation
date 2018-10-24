package com.slandshow.service;


import com.slandshow.DTO.StationDTO;
import com.slandshow.exceptions.InvalidStationException;
import com.slandshow.models.Station;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StationService {

   Station getStationByName(String name);

   void add(StationDTO stationDTO) throws InvalidStationException;

   void delete(String name) throws InvalidStationException;

   void update(StationDTO stationDTO) throws InvalidStationException;

   void reestablish(String name);

   List<StationDTO> getAll();

   List<Station> getAllStations();

   List<StationDTO> getAllDeletedStations();

   Station getById(Long id);

   Station getByName(String name);

   List<String> getStationsName();
}
