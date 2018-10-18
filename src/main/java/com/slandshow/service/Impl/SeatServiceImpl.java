package com.slandshow.service.Impl;

import com.slandshow.DAO.SeatDAO;
import com.slandshow.DTO.SeatDTO;
import com.slandshow.models.Seat;
import com.slandshow.models.Train;
import com.slandshow.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
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

    public List<List<SeatDTO>> createSeatsMatrix(int row, int col) {

        // Create matrix of seats (carriages x seats)
        List<List<SeatDTO>> carriages = new ArrayList<List<SeatDTO>>();

        int seatsCount = 1;
        for (int carriagesIterator = 1; carriagesIterator <= row; carriagesIterator++) {
            ArrayList<SeatDTO> seats = new ArrayList<SeatDTO>();
            seatsCount = 1;
            for (int seatsIterator = 1; seatsIterator <= col; seatsIterator++) {
                seats.add(new SeatDTO(carriagesIterator, seatsCount++));
            }

            carriages.add(seats);
        }

        return carriages;
    }
}
