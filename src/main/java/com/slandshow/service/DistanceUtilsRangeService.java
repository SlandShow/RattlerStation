package com.slandshow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DistanceUtilsRangeService {

    /* ====Constants==== */

    private final static Integer TRAIN_SPEED = 60;
    private final static Integer EARTH_RADIUS = 6371;
    private final static Integer DATE = 1000 * 60 * 60 * 24;
    private final static Integer HOURS = DATE / 24;
    private final static Double RADIANS = Math.PI / 180;
    private final static Double PRICE = 5.0;
    private final static Double DAY = 62.35;

    @Autowired
    private StationService stationService;



}
