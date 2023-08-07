package com.fabric.waterManagement.model;

public class Rate {

    private WaterLimit volume;

    private int rate;

    public Rate(WaterLimit volume, int rate) {
        this.volume = volume;
        this.rate = rate;
    }

    public WaterLimit getVolume() {
        return volume;
    }

    public void setVolume(WaterLimit volume) {
        this.volume = volume;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
}
