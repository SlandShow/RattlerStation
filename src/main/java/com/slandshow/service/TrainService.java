package com.slandshow.service;

import com.slandshow.models.Train;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TrainService {

    List<Train> getAllTrains();

}
