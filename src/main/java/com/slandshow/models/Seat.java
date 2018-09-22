package com.slandshow.models;

import javax.persistence.*;

@Entity
@Table(name = "seat")
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "carriage")
    private Integer carriage;

    @Column(name = "seat")
    private Integer seat;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "train_id", nullable = false)
    private Train train;

    public Seat() {
    }

    public Seat(Integer carriage, Integer seat, Train train) {
        this.carriage = carriage;
        this.seat = seat;
        this.train = train;
    }

    // Setters

    public void setId(Long id) {
        this.id = id;
    }

    public void setCarriage(Integer carriage) {
        this.carriage = carriage;
    }

    public void setSeat(Integer seat) {
        this.seat = seat;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    // Getters


    public Long getId() {
        return id;
    }

    public Integer getCarriage() {
        return carriage;
    }

    public Integer getSeat() {
        return seat;
    }

    public Train getTrain() {
        return train;
    }


}
