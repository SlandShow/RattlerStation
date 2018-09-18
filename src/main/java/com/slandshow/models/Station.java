package com.slandshow.models;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "station")
public class Station {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

    @OneToOne
    @NotNull
    private State state;

    public Station() {
    }

    public Station(String name, Double latitude, Double longitude, State state) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.state = state;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public void setState(State state) {
        this.state = state;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public State getState() {
        return state;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Station)) return false;
        if (this == obj) return true;

        Station anotherStation = (Station) obj;

        if (this.longitude.equals(anotherStation.longitude)
                && this.latitude.equals(anotherStation.latitude)
                && this.name.equals(anotherStation.name))
                    return true;

        return false;
    }

    @Override
    public String toString() {
        return "Station ( id: " + id + ", name: " + name +  " latitude: " + latitude + " longitude: " + longitude + " )";
    }
}
