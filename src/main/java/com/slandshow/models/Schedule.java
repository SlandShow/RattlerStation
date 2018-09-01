package com.slandshow.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "schedule")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "date_departure")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDeparture;

    @Column(name = "date_arrival")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateArrival;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "station_departure_id", referencedColumnName = "id")
    private Station stationDeparture;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "station_arrival_id", referencedColumnName = "id")
    private Station stationArrival;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "train_id", referencedColumnName = "id")
    private Train train;


    public Schedule() {
    }

    public Schedule(Date dateDeparture, Date dateArrival, Station stationDeparture, Station stationArrival, Train train) {
        this.dateDeparture = dateDeparture;
        this.dateArrival = dateArrival;
        this.stationDeparture = stationDeparture;
        this.stationArrival = stationArrival;
        this.train = train;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setDateDeparture(Date dateDeparture) {
        this.dateDeparture = dateDeparture;
    }

    public void setDateArrival(Date dateArrival) {
        this.dateArrival = dateArrival;
    }

    public void setStationDeparture(Station stationDeparture) {
        this.stationDeparture = stationDeparture;
    }

    public void setStationArrival(Station stationArrival) {
        this.stationArrival = stationArrival;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public Date getDateDeparture() {
        return dateDeparture;
    }

    public Date getDateArrival() {
        return dateArrival;
    }

    public Station getStationDeparture() {
        return stationDeparture;
    }

    public Station getStationArrival() {
        return stationArrival;
    }

    public Train getTrain() {
        return train;
    }

    @Override
    public String toString() {
        return "Schedule ( id: " + id + ", dateDeparture: " +
                dateDeparture.toString() + ", dateArrival: " +
                dateArrival.toString() + ", stationDeparture: " +
                stationDeparture.getName() + ", stationArrival: " +
                stationArrival.getName() + ", train: " +
                train.getName() + " )";
    }
}