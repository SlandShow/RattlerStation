package com.slandshow.models;

import javax.persistence.*;

@Entity
@Table(name = "edge")
public class Edge {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "station_start_id", referencedColumnName = "id")
    private Station stationStart;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "station_end_id", referencedColumnName = "id")
    private Station stationEnd;

    @Column(name = "range_distance")
    private Integer rangeDistance;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "branch_id", referencedColumnName = "id")
    private Branch branch;

    public Edge() {
    }

    // Setters

    public void setId(Long id) {
        this.id = id;
    }

    public void setStationStart(Station stationStart) {
        this.stationStart = stationStart;
    }

    public void setStationEnd(Station stationEnd) {
        this.stationEnd = stationEnd;
    }

    public void setRangeDistance(Integer rangeDistance) {
        this.rangeDistance = rangeDistance;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    // Branch

    public Long getId() {
        return id;
    }

    public Station getStationStart() {
        return stationStart;
    }

    public Station getStationEnd() {
        return stationEnd;
    }

    public Integer getRangeDistance() {
        return rangeDistance;
    }

    public Branch getBranch() {
        return branch;
    }
}
