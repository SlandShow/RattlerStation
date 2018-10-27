package com.slandshow.DTO;

import java.util.Date;

public class BookingTicketInfoDTO {

    private String user;

    private Integer seatNumber;

    private Integer carriageNumber;

    private Long trainId;

    private String trainName;

    private String stationDepartureName;

    private String stationArrivalName;

    private Date dateDeparture;

    private Date dateArrival;

    private Integer price;


    public BookingTicketInfoDTO() {
    }

    public BookingTicketInfoDTO(String user, Integer seatNumber, Integer carriageNumber, Long trainId) {
        this.user = user;
        this.seatNumber = seatNumber;
        this.carriageNumber = carriageNumber;
        this.trainId = trainId;
    }

    // Setters

    public void setUser(String user) {
        this.user = user;
    }

    public void setSeatNumber(Integer seatNumber) {
        this.seatNumber = seatNumber;
    }

    public void setCarriageNumber(Integer carriageNumber) {
        this.carriageNumber = carriageNumber;
    }

    public void setTrainId(Long trainId) {
        this.trainId = trainId;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public void setStationDepartureName(String stationDepartureName) {
        this.stationDepartureName = stationDepartureName;
    }

    public void setStationArrivalName(String stationArrivalName) {
        this.stationArrivalName = stationArrivalName;
    }

    public void setDateArrival(Date dateArrival) {
        this.dateArrival = dateArrival;
    }

    public void setDateDeparture(Date dateDeparture) {
        this.dateDeparture = dateDeparture;
    }

    // Getters

    public String getUser() {
        return user;
    }

    public Integer getSeatNumber() {
        return seatNumber;
    }

    public Integer getCarriageNumber() {
        return carriageNumber;
    }

    public Long getTrainId() {
        return trainId;
    }

    public String getTrainName() {
        return trainName;
    }

    public String getStationArrivalName() {
        return stationArrivalName;
    }

    public String getStationDepartureName() {
        return stationDepartureName;
    }

    public Date getDateArrival() {
        return dateArrival;
    }

    public Date getDateDeparture() {
        return dateDeparture;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
