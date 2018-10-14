package com.slandshow.DTO;

import java.io.Serializable;
import java.util.Date;

public class ScheduleDTO implements Serializable {

    private Long id;

    private String stationDepartureName;

    private String stationArrivalName;

    private String trainName;

    private String dateDeparture;

    private String dateArrival;

    private Integer price;

    public ScheduleDTO() {
    }

    // Setters

    public void setId(Long id) {
        this.id = id;
    }

    public void setStationDepartureName(String stationDepartureName) {
        this.stationDepartureName = stationDepartureName;
    }

    public void setStationArrivalName(String stationArrivalName) {
        this.stationArrivalName = stationArrivalName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public void setDateDeparture(String dateDeparture) {
        this.dateDeparture = dateDeparture;
    }

    public void setDateArrival(String dateArrival) {
        this.dateArrival = dateArrival;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    // Getters

    public Long getId() {
        return id;
    }

    public String getStationDepartureName() {
        return stationDepartureName;
    }

    public String getStationArrivalName() {
        return stationArrivalName;
    }

    public String getDateDeparture() {
        return dateDeparture;
    }

    public String getDateArrival() {
        return dateArrival;
    }

    public Integer getPrice() {
        return price;
    }

    public String getTrainName() {
        return trainName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ScheduleDTO that = (ScheduleDTO) o;

        return ((ScheduleDTO) o).trainName.equals(this.getTrainName());
    }

    @Override
    public int hashCode() {
        return trainName.hashCode();
    }
}
