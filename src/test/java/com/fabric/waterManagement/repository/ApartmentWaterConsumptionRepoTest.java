package com.fabric.waterManagement.repository;

import com.fabric.waterManagement.model.Apartment;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ApartmentWaterConsumptionRepoTest {

    @Test
    void getEstimatedWaterConsumption() {

        Map<Integer, Apartment> apartmentMap = ApartmentWaterConsumptionRepo.getEstimatedWaterConsumption();
        assertNotNull(apartmentMap);
        assertEquals(apartmentMap.size(), 2);
    }

    @Test
    void findByTypeValid() {
        int apartmentType = 2;
        Apartment apartment = ApartmentWaterConsumptionRepo.findByType(apartmentType);
        assertNotNull(apartment);
        assertEquals(apartment.getNoOFRooms().intValue(), 2);
        assertEquals(apartment.getEstimatedOccupants().intValue(), 3);
    }

    @Test
    void findByTypeInValid() {
        int apartmentType = 4;
        Apartment apartment = ApartmentWaterConsumptionRepo.findByType(apartmentType);
        assertNull(apartment);
    }
}