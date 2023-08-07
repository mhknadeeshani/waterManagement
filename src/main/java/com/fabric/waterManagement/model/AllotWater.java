package com.fabric.waterManagement.model;

import com.fabric.waterManagement.enums.ApartmentType;

public class AllotWater {

    private String apartmentType;
    private String waterRatio;

    private Integer noOFGuest;

    public String getApartmentType() {
        return apartmentType;
    }

    public void setApartmentType(String apartmentType) {
        this.apartmentType = apartmentType;
    }

    public String getWaterRatio() {
        return waterRatio;
    }

    public void setWaterRatio(String waterRatio) {
        this.waterRatio = waterRatio;
    }

    public Integer getNoOFGuest() {
        return noOFGuest;
    }

    public void setNoOFGuest(Integer noOFGuest) {
        this.noOFGuest = noOFGuest;
    }

    @Override
    public String toString() {
        return "AllotWater{" +
                "apartmentType=" + apartmentType +
                ", waterRatio='" + waterRatio + '\'' +
                ", noOFGuest=" + noOFGuest +
                '}';
    }
}
