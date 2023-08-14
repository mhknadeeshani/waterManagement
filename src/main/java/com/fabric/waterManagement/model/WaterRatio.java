package com.fabric.waterManagement.model;

import java.util.Objects;

public class WaterRatio {

    private Double corporation;

    private Double boreWell;

    public Double getCorporation() {
        return corporation;
    }

    public void setCorporation(Double corporation) {
        this.corporation = corporation;
    }

    public Double getBoreWell() {
        return boreWell;
    }

    public void setBoreWell(Double boreWell) {
        this.boreWell = boreWell;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WaterRatio that = (WaterRatio) o;
        return corporation.equals(that.corporation) && boreWell.equals(that.boreWell);
    }

    @Override
    public int hashCode() {
        return Objects.hash(corporation, boreWell);
    }
}


