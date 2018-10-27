package com.slandshow.DTO;

import java.io.Serializable;

public class TicketDTO implements Serializable {

    private Long scheduleId;

    private SeatDTO seatDTO;

    private Integer price;

    public TicketDTO() {
    }

    public TicketDTO(Long scheduleId, SeatDTO seatDTO) {
        this.scheduleId = scheduleId;
        this.seatDTO = seatDTO;
    }

    // Setters

    public void setScheduleId(Long scheduleId) {
        this.scheduleId = scheduleId;
    }

    public void setSeatDTO(SeatDTO seatDTO) {
        this.seatDTO = seatDTO;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    // Getters


    public Long getScheduleId() {
        return scheduleId;
    }

    public SeatDTO getSeatDTO() {
        return seatDTO;
    }

    public Integer getPrice() {
        return price;
    }

}
