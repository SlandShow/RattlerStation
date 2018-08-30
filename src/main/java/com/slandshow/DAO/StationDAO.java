package com.slandshow.DAO;

import com.slandshow.models.Station;
import org.springframework.stereotype.Repository;

@Repository
public interface StationDAO<E extends Station> extends GenericDAO<E> {

    Station getByName(String name);
}
