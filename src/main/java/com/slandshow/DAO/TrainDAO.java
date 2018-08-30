package com.slandshow.DAO;

import com.slandshow.models.Schedule;
import com.slandshow.models.Train;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainDAO<E extends Train> extends GenericDAO<E> {

    Train getByName(String name);

    Schedule getLastSchedule(Train train);
}
