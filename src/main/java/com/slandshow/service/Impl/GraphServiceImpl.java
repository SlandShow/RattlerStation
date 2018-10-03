package com.slandshow.service.Impl;

import com.slandshow.DAO.MappingGraphDAO;
import com.slandshow.DTO.EdgeDTO;
import com.slandshow.models.MappingEdge;
import com.slandshow.service.GraphService;
import com.slandshow.utils.Algorithms.Graph.Graph;
import com.slandshow.utils.Algorithms.GraphExecuter;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class GraphServiceImpl implements GraphService {

    private static final Graph<String> GRAPH_MODEL = new Graph<String>(false);

    private static final Logger LOGGER = Logger.getLogger(GraphServiceImpl.class);

    @Autowired
    private MappingGraphDAO mappingGraphDAO;

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

    private EdgeDTO mapping() {
        return null;
    }
}
