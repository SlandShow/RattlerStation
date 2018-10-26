package com.slandshow.service;

import com.slandshow.DTO.ScheduleDTO;
import com.slandshow.models.Schedule;
import com.slandshow.models.Station;
import com.slandshow.utils.DistanceManager;
import com.slandshow.utils.UtilsManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.geom.Point2D;
import java.text.ParseException;
import java.util.Date;

@Component
public class DistanceAndPriceUtilsService {

    @Autowired
    private StationService stationService;

    /**
     * PRICE = DISTANCE * K1 - (DATE_DEPARTURE - CURRENT_DATE) * K2;
     *
     * @param scheduleDTO
     * @return
     */
    public Integer calculateDirectTripPrice(ScheduleDTO scheduleDTO) throws ParseException {
        Date dateDeparture = UtilsManager.parseToDateTime(scheduleDTO.getDateDeparture());
        Station stationDeparture = stationService.getByName(scheduleDTO.getStationDepartureName());
        Station stationArrival = stationService.getByName(scheduleDTO.getStationArrivalName());
        if (!dateDeparture.before(UtilsManager.getTodayDateTime())) {
            Date date = UtilsManager.getTodayDateTime();
            Point2D pointDeparture = new Point2D.Double(stationDeparture.getLatitude(), stationDeparture.getLongitude());
            Point2D pointArrival = new Point2D.Double(stationArrival.getLatitude(), stationArrival.getLongitude());
            Double distance = distance(pointDeparture, pointArrival);
        /*
        count dates between
         */
            Long deltaDates = (dateDeparture.getTime() - date.getTime()) / DistanceManager.DATE;
            return (int) (distance * DistanceManager.K_PRICE - deltaDates * DistanceManager.K_DAY);
        } else return 0;
    }

    public Integer calculateDirectTripPrice(Schedule schedule) throws ParseException {
        if (!schedule.getDateDeparture().before(new Date())) {
            Date date = UtilsManager.getTodayDateTime();
            Point2D pointDeparture = new Point2D.Double(schedule.getStationDeparture().getLatitude(),
                    schedule.getStationDeparture().getLongitude());
            Point2D pointArrival = new Point2D.Double(schedule.getStationArrival().getLatitude(),
                    schedule.getStationArrival().getLongitude());
            Double distance = distance(pointDeparture, pointArrival);
        /*
        count dates between
         */
            Long deltaDates = (schedule.getDateDeparture().getTime() - date.getTime()) / DistanceManager.DATE;
            return (int) (distance * DistanceManager.K_PRICE - deltaDates * DistanceManager.K_DAY);
        } else return 0;
    }

    public Integer calculateTransferTripPrice(Schedule scheduleDeparture, Schedule scheduleArrival) throws ParseException {
        Date dateDeparture = scheduleDeparture.getDateDeparture();
        Station stationDeparture = scheduleDeparture.getStationDeparture();
        Station stationIntermediate = scheduleDeparture.getStationArrival();
        Station stationArrival = scheduleArrival.getStationArrival();
        if (!dateDeparture.before(UtilsManager.getTodayDateTime())) {
            Date date = UtilsManager.getTodayDateTime();
            Point2D pointDeparture = new Point2D.Double(stationDeparture.getLatitude(), stationDeparture.getLongitude());
            Point2D pointIntermediateDeparture = new Point2D.Double(stationIntermediate.getLatitude(), stationIntermediate.getLongitude());
            Point2D pointArrival = new Point2D.Double(stationArrival.getLatitude(), stationArrival.getLongitude());
            Double distanceA = distance(pointDeparture, pointIntermediateDeparture);
            Double distanceB = distance(pointIntermediateDeparture, pointArrival);
        /*
        count dates between
         */
            Long deltaDates = (dateDeparture.getTime() - date.getTime()) / DistanceManager.DATE;
            return (int) ((distanceA + distanceB) * DistanceManager.K_PRICE - deltaDates * DistanceManager.K_DAY);
        } else return 0;
    }

    /**
     * DATE_ARRIVAL = DATE_DEPARTURE + DISTANCE / SPEED_TRAIN;
     *
     * @param dateDeparture
     * @param stationArrival
     * @param stationDeparture
     * @return
     */
    public Date calculateDateArrival(Date dateDeparture, Station stationDeparture, Station stationArrival) throws ParseException {
        Date newDate = UtilsManager.getTodayDateTime();
        Point2D pointDeparture = new Point2D.Double(stationDeparture.getLatitude(), stationDeparture.getLongitude());
        Point2D pointArrival = new Point2D.Double(stationArrival.getLatitude(), stationArrival.getLongitude());
        Double distance = distance(pointDeparture, pointArrival);
        /*
        time in milliseconds
         */
        Long time = Double.valueOf(distance * DistanceManager.HOURS / DistanceManager.SPEED_TRAIN).longValue();
        newDate.setTime(dateDeparture.getTime() + time);
        return newDate;
    }

    /**
     * Formula gaversinusov with modification for antipodes
     *
     * @param pointA
     * @param pointB
     * @return distance in kilometers
     */
    private Double distance(Point2D pointA, Point2D pointB) {
        Double latitudeA = DistanceManager.RADIANS * pointA.getX();
        Double latitudeB = DistanceManager.RADIANS * pointB.getX();
        Double longitudeA = DistanceManager.RADIANS * pointA.getY();
        Double longitudeB = DistanceManager.RADIANS * pointB.getY();

        // calculating length of big round
        Double y = Math.sqrt(Math.pow(Math.cos(latitudeB) * Math.sin(longitudeB - longitudeA), 2)
                + Math.pow(Math.cos(latitudeA) * Math.sin(latitudeB) - Math.sin(latitudeA) * Math.cos(latitudeB) * Math.cos(longitudeB - longitudeA), 2));
        Double x = Math.sin(latitudeA) * Math.sin(latitudeB) + Math.cos(latitudeA) * Math.cos(latitudeB) * Math.cos(longitudeB - longitudeA);

        return Math.atan2(y, x) * DistanceManager.EARTH_RADIUS;
    }

    /**
     * if manager set his own schedule with fix date departure/arrival speed will be another (not 70 km/hour)
     * * @return speed in km/s
     */
    public Double getSpeed(Schedule schedule) {
        Point2D pointDeparture = new Point2D.Double(schedule.getStationDeparture().getLatitude(),
                schedule.getStationDeparture().getLongitude());
        Point2D pointArrival = new Point2D.Double(schedule.getStationArrival().getLatitude(),
                schedule.getStationArrival().getLongitude());
        Date dateDeparture = schedule.getDateDeparture();
        Date dateArrival = schedule.getDateArrival();
        Double distance = distance(pointDeparture, pointArrival);
        Double time = Long.valueOf((dateArrival.getTime() - dateDeparture.getTime()) / 1000 / 60).doubleValue();
        return distance / time;
    }

    /**
     * time in trip in real time
     *
     * @return time in min
     */
    public Long getTimeInTripRealTime(Schedule schedule) throws ParseException {
        Date date = schedule.getDateDeparture();
        Date today = UtilsManager.getTodayDateTime();
        return (today.getTime() - date.getTime()) / 1000;
    }

}
