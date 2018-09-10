package com.slandshow.DTO;

import java.io.Serializable;

public class TicketInfoDTO implements Serializable {

    private Integer id;

    private String userFirstName;

    private String userLastName;

    private String userLogin;

    private String scheduleStationDepartureName;

    private String scheduleStationArrivalName;

    private String scheduleDateDeparture;

    private String scheduleTrainName;

    private String scheduleDateArrival;

    private Integer seatCarriage;

    private Integer seatSeat;

    private Integer price;

    public TicketInfoDTO() {
    }

    // Setters

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public void setSeatSeat(Integer seatSeat) {
        this.seatSeat = seatSeat;
    }

    public void setScheduleDateDeparture(String scheduleDateDeparture) {
        this.scheduleDateDeparture = scheduleDateDeparture;
    }

    public void setScheduleStationArrivalName(String scheduleStationArrivalName) {
        this.scheduleStationArrivalName = scheduleStationArrivalName;
    }

    public void setScheduleDateArrival(String scheduleDateArrival) {
        this.scheduleDateArrival = scheduleDateArrival;
    }

    public void setSeatCarriage(Integer seatCarriage) {
        this.seatCarriage = seatCarriage;
    }

    public void setScheduleTrainName(String scheduleTrainName) {
        this.scheduleTrainName = scheduleTrainName;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setScheduleStationDepartureName(String scheduleStationDepartureName) {
        this.scheduleStationDepartureName = scheduleStationDepartureName;
    }

    // Getters


    public Integer getId() {
        return id;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public String getScheduleDateDeparture() {
        return scheduleDateDeparture;
    }

    public String getScheduleStationArrivalName() {
        return scheduleStationArrivalName;
    }

    public String getScheduleStationDepartureName() {
        return scheduleStationDepartureName;
    }

    public String getScheduleDateArrival() {
        return scheduleDateArrival;
    }

    public String getScheduleTrainName() {
        return scheduleTrainName;
    }

    public Integer getSeatCarriage() {
        return seatCarriage;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getSeatSeat() {
        return seatSeat;
    }

    @Override
    public String toString() {
        return "Ticket DTO Info (userLogin = " + userLogin + " seat = " + seatSeat + " carriage = " + seatCarriage + ")";
    }
}
