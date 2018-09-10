package com.slandshow.DTO;

/*
 * Free seats as SeatDTO
 */

import java.io.Serializable;

public class SeatDTO implements Serializable {

    private Integer carriage;

    private Integer seat;

    public SeatDTO() {
    }

    public SeatDTO(Integer carriage, Integer seat) {
      this.carriage = carriage;
      this.seat = seat;
    }

    // Setters

    public void setCarriage(Integer carriage) {
        this.carriage = carriage;
    }

    public void setSeat(Integer seat) {
        this.seat = seat;
    }

    // Getters

    public Integer getCarriage() {
        return carriage;
    }

    public Integer getSeat() {
        return seat;
    }
}
