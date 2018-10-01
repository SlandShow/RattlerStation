package com.slandshow.DTO;

public class EdgeDTO {

    private String stationStart;

    private String stationEnd;

    private String branch;

    private Double rangeDistance;

    public EdgeDTO() {
    }

    // Setters

    public void setStationStart(String stationStart) {
        this.stationStart = stationStart;
    }

    public void setStationEnd(String stationEnd) {
        this.stationEnd = stationEnd;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public void setRangeDistance(Double rangeDistance) {
        this.rangeDistance = rangeDistance;
    }

    // Getters

    public String getStationStart() {
        return stationStart;
    }

    public String getStationEnd() {
        return stationEnd;
    }

    public String getBranch() {
        return branch;
    }

    public Double getRangeDistance() {
        return rangeDistance;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof EdgeDTO))
            return false;

        EdgeDTO edge = (EdgeDTO) o;

        if (edge.stationStart == null || edge.stationEnd == null)
            return false;

        return (stationStart.equals(edge.stationStart) && stationEnd.equals(edge.stationEnd));
    }
}
