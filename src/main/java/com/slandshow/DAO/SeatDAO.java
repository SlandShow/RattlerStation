package com.slandshow.DAO;

import com.slandshow.models.Seat;
import com.slandshow.models.Train;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatDAO<E extends Seat> extends GenericDAO<E> {

    Seat getByTrainAndCarriageAndSeat(Train train, Integer carriage, Integer seat);
}