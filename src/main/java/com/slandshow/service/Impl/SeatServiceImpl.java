package com.slandshow.service.Impl;

import com.slandshow.DAO.SeatDAO;
import com.slandshow.models.Seat;
import com.slandshow.models.Train;
import com.slandshow.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class SeatServiceImpl implements SeatService {

    @Autowired
    private SeatDAO seatDAO;

    @Transactional
    public void add(Seat seat) {
        seatDAO.add(seat);
    }

    @Transactional
    public void delete(Seat seat) {
        seatDAO.delete(seat);
    }

    @Transactional
    public void update(Seat seat) {
        seatDAO.update(seat);
    }

    @Transactional
    public List<Seat> getAll() {
        return seatDAO.getAll();
    }

    @Transactional
    public Seat getById(Long id) {
        return (Seat) seatDAO.getById(id);
    }

    @Transactional
    public Seat getByTrainAndCarriageAndSeat(Train train, Integer carriage, Integer seat) {
        return seatDAO.getByTrainAndCarriageAndSeat(train, carriage, seat);
    }
}
