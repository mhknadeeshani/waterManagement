package com.fabric.waterManagement.model;

import java.util.List;

public class WaterDistribution {

    private String distributionType;

    private List<Rate> rate;

    public WaterDistribution(String distributionType, List<Rate> rate) {
        this.distributionType = distributionType;
        this.rate = rate;
    }

    public String getDistributionType() {
        return distributionType;
    }

    public void setDistributionType(String distributionType) {
        this.distributionType = distributionType;
    }

    public List<Rate> getRate() {
        return rate;
    }

    public void setRate(List<Rate> rate) {
        this.rate = rate;
    }
}
