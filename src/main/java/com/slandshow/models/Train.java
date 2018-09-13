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

    @OneToMany(mappedBy = "train", cascade = CascadeType.ALL)
    private Set<Seat> seats;

    public Train() {
    }

    public Train(String name, Set<Seat> seats) {
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

   public void setSeats(Set<Seat> seats) {
        this.seats = seats;
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

    @Override
    public String toString() {
        return "Train ( id: " + id + ", name: " + name + ", seats: " + "" + " )";
    }
}
