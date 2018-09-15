package com.slandshow.DTO;

import java.io.Serializable;

public class TrainDTO implements Serializable {

    private String name;

    private String newName;

    private Integer seatsCount;

    private Integer carriageCount;

    public TrainDTO() {

    }

    public TrainDTO(String name, String newName, Integer seatsCount, Integer carriageCount) {
        this.name = name;
        this.newName = newName;
        this.seatsCount = seatsCount;
        this.carriageCount = carriageCount;
    }

    // Setters

    public void setName(String name) {
        this.name = name;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public void setSeatsCount(Integer seatsCount) {
        this.seatsCount = seatsCount;
    }

    public void setCarriageCount(Integer carriageCount) {
        this.carriageCount = carriageCount;
    }

    // Getters


    public String getName() {
        return name;
    }

    public String getNewName() {
        return newName;
    }

    public Integer getSeatsCount() {
        return seatsCount;
    }

    public Integer getCarriageCount() {
        return carriageCount;
    }
}
