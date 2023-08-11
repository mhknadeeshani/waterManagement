package com.fabric.waterManagement.model;

public class Rate {

    private WaterLimit volume;

    private Double rate;

    public Rate(WaterLimit volume, Double rate) {
        this.volume = volume;
        this.rate = rate;
    }

    public WaterLimit getVolume() {
        return volume;
    }

    public void setVolume(WaterLimit volume) {
        this.volume = volume;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }
}
