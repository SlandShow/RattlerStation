package com.slandshow.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "train")
public class Train {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "train", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Seat> seats;

    @OneToOne
    private State state;

    @Column(name = "carriages")
    private Integer carriages;

    public Train() {
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSeats(Set<Seat> seats) {
        this.seats = seats;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void setCarriages(Integer carriages) {
        this.carriages = carriages;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Seat> getSeats() {
       return seats;
    }

    public State getState() {
        return state;
    }

    public Integer getCarriages() {
        return carriages;
    }

}
