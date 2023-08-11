package com.fabric.waterManagement.model;

import java.util.Objects;

public class Bill {

    private Integer totalWaterConsumed;
    private Integer totalCost;

    public Integer getTotalWaterConsumed() {
        return totalWaterConsumed;
    }

    public void setTotalWaterConsumed(Integer totalWaterConsumed) {
        this.totalWaterConsumed = totalWaterConsumed;
    }

    public Integer getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Integer totalCost) {
        this.totalCost = totalCost;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "totalWaterConsumed=" + totalWaterConsumed +
                ", totalCost=" + totalCost +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bill bill = (Bill) o;
        return totalWaterConsumed.equals(bill.totalWaterConsumed) && totalCost.equals(bill.totalCost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalWaterConsumed, totalCost);
    }
}
