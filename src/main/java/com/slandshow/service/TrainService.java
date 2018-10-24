package com.slandshow.service;

import com.slandshow.DTO.TrainDTO;
import com.slandshow.DTO.TrainInfoDTO;
import com.slandshow.exceptions.InvalidTrainException;
import com.slandshow.models.Train;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TrainService {

    void add(TrainDTO trainDTO) throws InvalidTrainException;

    void delete(String name) throws InvalidTrainException;

    void update(TrainDTO trainDTO) throws InvalidTrainException;

    void reestablish(String name);

    List<TrainDTO> getAll();

    List<Train> getAllTrains();

    List<Train> getAllValidTrains();

    Train getById(Long id);

    Train getByName(String name);

    List<TrainInfoDTO> getLastPositionTrain();

    List<TrainDTO> getAllDeletedTrains();

    List<String> getTrainsName();

}
