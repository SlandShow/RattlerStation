package com.slandshow.DTO;

import java.io.Serializable;

public class TrainInfoDTO implements Serializable {

    private String name;

    private String stationName;

    private String dateDeparture;

    private String dateArrival;

    private Integer cntCarriage;

    private Integer cntSeats;

    private  Double latitude;

    private Double longitude;

    public TrainInfoDTO() {
    }

    // Setters

    public void setName(String name) {
        this.name = name;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public void setDateDeparture(String dateDeparture) {
        this.dateDeparture = dateDeparture;
    }

    public void setDateArrival(String dateArrival) {
        this.dateArrival = dateArrival;
    }

    public void setCntCarriage(Integer cntCarriage) {
        this.cntCarriage = cntCarriage;
    }

    public void setCntSeats(Integer cntSeats) {
        this.cntSeats = cntSeats;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    // Getters

    public String getName() {
        return name;
    }

    public String getStationName() {
        return stationName;
    }

    public String getDateDeparture() {
        return dateDeparture;
    }

    public String getDateArrival() {
        return dateArrival;
    }

    public Integer getCntCarriage() {
        return cntCarriage;
    }

    public Integer getCntSeats() {
        return cntSeats;
    }

    public Double getLongitude() {
        return longitude;
    }

    public Double getLatitude() {
        return latitude;
    }
}
