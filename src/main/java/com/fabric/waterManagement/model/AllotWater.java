package com.fabric.waterManagement.model;

import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AllotWater that = (AllotWater) o;
        return apartmentType.equals(that.apartmentType) && waterRatio.equals(that.waterRatio) && Objects.equals(noOFGuest, that.noOFGuest);
    }

    @Override
    public int hashCode() {
        return Objects.hash(apartmentType, waterRatio, noOFGuest);
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
