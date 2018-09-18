package com.slandshow.DTO;

import java.io.Serializable;
import java.util.List;

public class SeatsDTO implements Serializable {

    private List<SeatDTO> bookingSeats;

    private Integer cntCarriages;

    public SeatsDTO() {
    }

    // Setters

    public void setBookingSeats(List<SeatDTO> bookingSeats) {
        this.bookingSeats = bookingSeats;
    }

    public void setCntCarriages(Integer cntCarriages) {
        this.cntCarriages = cntCarriages;
    }

    // Getters

    public List<SeatDTO> getBookingSeats() {
        return bookingSeats;
    }

    public Integer getCntCarriages() {
        return cntCarriages;
    }
}
