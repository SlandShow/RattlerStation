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
    private Date dateDeparture;

    @Column(name = "date_arrival")
    private Date dateArrival;

    @OneToOne
    private Station stationDeparture;

    @OneToOne
    private Station stationArrival;

    @OneToOne
    private Train train;

    public Schedule() {
    }




}
