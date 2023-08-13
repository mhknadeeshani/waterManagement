package com.fabric.waterManagement.service;

import com.fabric.waterManagement.enums.WaterDistributionMethod;
import com.fabric.waterManagement.model.AllotWater;
import com.fabric.waterManagement.model.Bill;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BillServiceTest {


    BillService billService;
    AllotWater allotWater;
    Integer occupantsWaterConsumption;
    WaterDistributionMethod waterDistributionMethod;
    Bill finalBill;


    @BeforeEach
    public void setUp() {

        allotWater = new AllotWater();
        allotWater.setWaterRatio("3:7");
        allotWater.setApartmentType("2");
        allotWater.setNoOFGuest(5);
        billService = new BillService();

        finalBill = new Bill();
        finalBill.setTotalWaterConsumed(2400);
        finalBill.setTotalCost(5215);
    }

    @Test
    public void getFlatRateTest() {
        waterDistributionMethod = WaterDistributionMethod.BOREWELL;
        double corporationWaterVolume = 1200d;
        double flatRate = billService.getFlatRate(waterDistributionMethod, corporationWaterVolume);

        Assertions.assertEquals(flatRate, 1.5d);
    }

    @Test
    public void getWaterBillForOccupantsTest() {
        occupantsWaterConsumption = 900;
        double billForOccupants = billService.getWaterBillForOccupants(occupantsWaterConsumption, allotWater);
        Assertions.assertEquals(billForOccupants, 1215d);
    }

    @Test
    public void getSlabRateBillTest() {
        waterDistributionMethod = WaterDistributionMethod.TANKER;
        Integer guestWaterConsumption = 1500;
        double billForGuess = billService.getSlabRateBill(guestWaterConsumption, waterDistributionMethod);
        Assertions.assertEquals(billForGuess, 4000);
    }

    @Test
    public void generateFinalBillTest() {
        Bill bill = billService.generateFinalBill(allotWater);
        Assertions.assertEquals(finalBill, bill);
    }
}
