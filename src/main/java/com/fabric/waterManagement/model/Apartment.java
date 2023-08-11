package com.fabric.waterManagement.model;

public class Apartment {

    private Integer noOFRooms;

    private Integer estimatedOccupants;

    public Apartment(Integer noOFRooms, Integer estimatedOccupants) {
        this.noOFRooms = noOFRooms;
        this.estimatedOccupants = estimatedOccupants;
    }

    public Integer getNoOFRooms() {
        return noOFRooms;
    }

    public void setNoOFRooms(Integer noOFRooms) {
        this.noOFRooms = noOFRooms;
    }

    public Integer getEstimatedOccupants() {
        return estimatedOccupants;
    }

    public void setEstimatedOccupants(Integer estimatedOccupants) {
        this.estimatedOccupants = estimatedOccupants;
    }
}
