package com.slandshow.service.Impl;

import com.slandshow.DAO.MappingGraphDAO;
import com.slandshow.DTO.EdgeDTO;
import com.slandshow.DTO.ScheduleDTO;
import com.slandshow.models.MappingEdge;
import com.slandshow.models.Schedule;
import com.slandshow.service.DistanceAndPriceUtilsService;
import com.slandshow.service.GraphService;
import com.slandshow.service.ScheduleService;
import com.slandshow.utils.Algorithms.Graph.Graph;
import com.slandshow.utils.Algorithms.GraphExecuter;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class GraphServiceImpl implements GraphService {

    public static boolean GRAPH_IS_BUILDED = false;
    private static final Graph<String> GRAPH_MODEL = new Graph<String>(false);
    private static final Logger LOGGER = Logger.getLogger(GraphServiceImpl.class);

    @Autowired
    private MappingGraphDAO mappingGraphDAO;

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private DistanceAndPriceUtilsService distanceService;

    @Transactional
    public void addEdge(MappingEdge edge) {
        mappingGraphDAO.add(edge);

        GRAPH_MODEL.addEdge(
                edge.getStationStart().getName(),
                edge.getStationEnd().getName(),
                edge.getRangeDistance()
        );

        LOGGER.info(
                                "NEW EDGE ADDED TO DATABASE AND GRAPH: "
                                + edge.getStationStart() + " -> " + edge.getStationEnd()
                                + " in distance " + edge.getRangeDistance()
        );
    }

    @Transactional
    public void buildGraph() {

        if (GRAPH_IS_BUILDED)
            return;

        List<MappingEdge> allEdges = mappingGraphDAO.getAllEdges();

        for (MappingEdge currentEdge: allEdges) {
            EdgeDTO edgeDTO = new EdgeDTO();
            edgeDTO.setStationStart(currentEdge.getStationStart().getName().intern());
            edgeDTO.setStationEnd(currentEdge.getStationEnd().getName().intern());
            edgeDTO.setBranch(currentEdge.getBranch().getName().intern());
            edgeDTO.setRangeDistance(currentEdge.getRangeDistance());

            GRAPH_MODEL.addEdge(
                                edgeDTO.getStationStart(),
                                edgeDTO.getStationEnd(),
                                edgeDTO.getRangeDistance()
            );
        }

        LOGGER.info("BUILD GRAPH: \n" + GRAPH_MODEL.toString());

        GRAPH_IS_BUILDED = true;
    }

    public void deleteEdge(EdgeDTO edgeDTO) {

    }

    public List<String> searchEdges(String start, String end) {
        return GraphExecuter.shortestUnweightedPath(
                GRAPH_MODEL,
                start,
                end
        );
    }

    @Transactional
    public List<EdgeDTO> getAllEdges() {
        return mappingGraphDAO.getAllEdges();
    }

    public String[] parsePath(List<String> path) {
        if (path.size() < 2)
            return null;

        String[] validPath = new String[path.size() - 1];

        for (int i = 0; i < path.size() - 1; i++) {
            validPath[i] = path.get(i) + "->" + path.get(i + 1);
            LOGGER.info("PARSED PATH IS " + validPath[i]);
        }

        return validPath;
    }

    private void deleteUnique(Map<ScheduleDTO, List<Schedule>> map, int path) {
        map.entrySet().removeIf(entry -> entry.getValue().size() != path);
    }

    public Map<ScheduleDTO, List<Schedule>> filter(List<Schedule> list) {
        Map<ScheduleDTO, List<Schedule>> filtered = new HashMap<>();

        for (Schedule aList : list) {
            ScheduleDTO scheduleDTO = new ScheduleDTO();
            scheduleDTO.setTrainName(
                    aList.getTrain().getName()
            );

            scheduleDTO.setStationDepartureName(
                    aList.getStationDeparture().getName()
            );

            scheduleDTO.setStationArrivalName(
                    aList.getStationArrival().getName()
            );

            scheduleDTO.setDateDeparture(
                    aList.getDateDeparture().toString()
            );

            scheduleDTO.setDateArrival(
                    aList.getDateArrival().toString()
            );

            if (!filtered.containsKey(scheduleDTO))
                filtered.put(scheduleDTO, new ArrayList<>());

            if (filtered.containsKey(scheduleDTO))
                filtered.get(scheduleDTO).add(aList);
        }

        return filtered;
    }

    public List<ScheduleDTO> parsedListFromMap(Map<ScheduleDTO, List<Schedule>> filtered) {
        List<ScheduleDTO> parsed = new ArrayList<>();

        for (Map.Entry<ScheduleDTO, List<Schedule>> entry : filtered.entrySet()) {
            ScheduleDTO iterated = new ScheduleDTO();
            iterated.setStationDepartureName(
                    filtered.get(entry.getKey()).get(0).getStationDeparture().getName()
            );

            iterated.setStationArrivalName(
                    filtered.get(entry.getKey())
                            .get(filtered.get(entry.getKey()).size() - 1)
                            .getStationArrival().getName()
            );

            iterated.setDateDeparture(
              filtered.get(entry.getKey()).get(0).getDateDeparture().toString()
            );

            iterated.setDateArrival(
                    filtered.get(entry.getKey())
                            .get(filtered.get(entry.getKey()).size() - 1)
                            .getDateArrival().toString()
            );

            iterated.setTrainName(entry.getKey().getTrainName());

            parsed.add(iterated);
        }

        return parsed;
    }

    public Map<ScheduleDTO, List<Schedule>> puzzleSchedules(String[] path, String dateDeparture, String dateArrival) throws ParseException {
        List<Schedule> puzzled = new ArrayList<>();

        for (int i = 0; i < path.length; i++) {
            ScheduleDTO schedule = new ScheduleDTO();
            schedule.setStationDepartureName(path[i].split("->")[0]);
            schedule.setStationArrivalName(path[i].split("->")[1]);
            schedule.setDateDeparture(dateDeparture);

            if (!dateArrival.equals("") && i == path.length - 1)
                schedule.setDateArrival(dateArrival);
            else schedule.setDateArrival("");


            Schedule realSchedule = scheduleService.mapping(schedule);

            if (realSchedule.getDateArrival() != null) {
                List<Schedule> tmp = scheduleService.getByStationsAndDates(realSchedule);
                puzzled.addAll(tmp);
            } else {
                List<Schedule> tmp = scheduleService.getByStationsAndDate(realSchedule);
                puzzled.addAll(tmp);
            }
        }

        // LOGOUT ALL STUFF
        for (Schedule aPuzzled : puzzled) {
            LOGGER.info(
                    "BEFORE PUZZLED ---->" +
                            aPuzzled.getStationDeparture().getName()
                            + " - > " + aPuzzled.getStationArrival().getName()
                            + " -- " + aPuzzled.getDateDeparture()
                            + " - > " + aPuzzled.getDateArrival()
                            + " TRAIN " + aPuzzled.getTrain().getName()
            );
        }

        // Create map of schedulers (key <DTO>, value <List>
        Map<ScheduleDTO, List<Schedule>> schedulersMap = filter(puzzled);

        // Filter map - delete invalid schedulers
        deleteUnique(schedulersMap, path.length);

        return schedulersMap;
    }

}
