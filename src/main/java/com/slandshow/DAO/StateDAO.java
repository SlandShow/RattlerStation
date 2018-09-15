package com.slandshow.DAO;

import com.slandshow.models.State;
import org.springframework.stereotype.Repository;

@Repository
public interface StateDAO <E extends State> extends GenericDAO<E> {

    State getByType(String type);

}
