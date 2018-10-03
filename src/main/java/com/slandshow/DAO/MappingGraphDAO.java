package com.slandshow.DAO;

import com.slandshow.models.MappingEdge;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MappingGraphDAO<E extends MappingEdge> extends GenericDAO<E> {

    List<MappingEdge> getAllEdges();

}
