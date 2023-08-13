package com.fabric.waterManagement.repository;

import com.fabric.waterManagement.model.Apartment;

import java.util.HashMap;
import java.util.Map;

import static com.fabric.waterManagement.util.Constants.APARTMENT_TYPE_1_ROOMS;
import static com.fabric.waterManagement.util.Constants.APARTMENT_TYPE_2_ROOMS;

public class ApartmentWaterConsumptionRepo {

    static Map<Integer, Apartment> apartmentEstimatedWater;

    static {
        apartmentEstimatedWater = new HashMap<>();
        apartmentEstimatedWater.put(APARTMENT_TYPE_1_ROOMS, new Apartment(2, 3));
        apartmentEstimatedWater.put(APARTMENT_TYPE_2_ROOMS, new Apartment(3, 5));
    }

    public static Map<Integer, Apartment> getEstimatedWaterConsumption() {
        return apartmentEstimatedWater;
    }

    public static Apartment findByType(Integer type){
        return apartmentEstimatedWater.getOrDefault(type, null);
    }
}
