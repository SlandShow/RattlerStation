package com.slandshow.service;

import com.slandshow.DTO.EdgeDTO;
import com.slandshow.DTO.ScheduleDTO;
import com.slandshow.models.MappingEdge;
import com.slandshow.models.Schedule;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

@Service
public interface GraphService {

    void addEdge(MappingEdge edge);

    void buildGraph();

    void deleteEdge(EdgeDTO edgeDTO);

    List<String> searchEdges(String start, String end);

    List<EdgeDTO> getAllEdges();

    String[] parsePath(List<String> path);

    List<Schedule> puzzleSchedules(String[] path, String dateDeparture, String dateArrival) throws ParseException;

    Map<ScheduleDTO, List<Schedule>> filter(List<Schedule> list);

    List<ScheduleDTO> parsedListFromMap(Map<ScheduleDTO, List<Schedule>> filtered);
}
