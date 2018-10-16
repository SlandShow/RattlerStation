package com.slandshow.models;

import javax.persistence.*;

@Entity
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "schedule_id", referencedColumnName = "id")
    private Schedule schedule;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToOne
    @JoinColumn(name = "seat_id", referencedColumnName = "id")
    private Seat seat;

    @Column(name = "price")
    private Integer price;

    public Ticket() {
    }

    public Ticket(Schedule schedule, User user, Seat seat, Integer price) {
        this.schedule = schedule;
        this.user = user;
        this.seat = seat;
        this.price = price;
    }

    // Setters

    public void setId(Long id) {
        this.id = id;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    // Getters


    public Long getId() {
        return id;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public User getUser() {
        return user;
    }

    public Seat getSeat() {
        return seat;
    }

    public Integer getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Ticket(id: "
                + id
                + " schedule: <"
                + schedule.getId() + "> user: < "
                + user.getFirstName()
                + user.getLastName()
                + " > price: " + price
                + ")";
    }
}
