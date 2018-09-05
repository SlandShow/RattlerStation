package com.slandshow.service.Impl;

import com.slandshow.DAO.TrainDAO;
import com.slandshow.models.Train;
import com.slandshow.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TrainServiceImpl implements TrainService {

    @Autowired
    private TrainDAO trainDAO;

    public void setTrainDAO(TrainDAO trainDAO) {
        this.trainDAO = trainDAO;
    }

    public List<Train> getAllTrains() {
        return trainDAO.getAll();
    }

}
