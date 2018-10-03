package com.slandshow.service;

import com.slandshow.DTO.EdgeDTO;
import com.slandshow.models.MappingEdge;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GraphService {

    void addEdge(MappingEdge edge);

    void buildGraph();

    void deleteEdge(EdgeDTO edgeDTO);

    List<String> searchEdges(String start, String end);

    List<EdgeDTO> getAllEdges();
}
