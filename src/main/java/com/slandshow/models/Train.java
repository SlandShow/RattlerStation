package com.slandshow.models;

import javax.persistence.*;

@Entity
@Table(name = "train")
public class Train {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    // TODO: CHANGE RELATION TO ONE-TO-MANY (private private Set<Seat> seats)
    @Column(name = "seats")
    private Integer seats;

    public Train() {
    }

    public Train(String name, Integer seats) {
        this.name = name;
        this.seats = seats;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    // TODO: CHANGE SETTER
    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getSeats() {
        return seats;
    }
}
