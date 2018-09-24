package com.slandshow.DTO;

public class BookingTicketInfoDTO {

    private String user;

    private Integer seatNumber;

    private Integer carriageNumber;

    private Long trainId;

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
}
