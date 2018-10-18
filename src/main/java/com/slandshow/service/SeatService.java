package com.slandshow.service;

import com.slandshow.DTO.SeatDTO;
import com.slandshow.models.Seat;
import com.slandshow.models.Train;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface SeatService {

    void add(Seat seat);

    void delete(Seat seat);

    void update(Seat seat);

    List<Seat> getAll();

    Seat getById(Long id);

    Seat getByTrainAndCarriageAndSeat(Train train, Integer carriage, Integer seat);

    List<List<SeatDTO>> createSeatsMatrix(int row, int col);
}
