package com.slandshow.DTO;

import java.io.Serializable;

public class StationDTO implements Serializable {

    private String name;

    private String newName;

    private Double latitude;

    private Double longitude;

    public StationDTO() {
    }

    // Setters

    public void setName(String name) {
        this.name = name;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    // Getters

    public String getName() {
        return name;
    }

    public String getNewName() {
        return newName;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }
}
