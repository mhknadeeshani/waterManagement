package com.fabric.waterManagement.service;

import com.fabric.waterManagement.enums.WaterDistributionMethods;
import com.fabric.waterManagement.model.*;
import com.fabric.waterManagement.repository.ApartmentWaterConsumptionRepo;
import com.fabric.waterManagement.repository.WaterDistributionRepo;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static com.fabric.waterManagement.enums.WaterDistributionMethods.*;
import static com.fabric.waterManagement.util.Constants.ALLOTTED_PER_DAY;
import static com.fabric.waterManagement.util.Constants.NO_OF_DAYS;

public class BillService {


    public Bill generateFinalBill(AllotWater allotWater) {
        Double occupantsBill;
        Double tankerBill;
        Bill finalBill = new Bill();
        double finalBillAmount;

        Map<Integer, Apartment> estimatedWater = ApartmentWaterConsumptionRepo.getEstimatedWaterConsumption();
        Integer waterConsumptionForOccupants = estimatedWater.get(Integer.parseInt(allotWater.getApartmentType())).getEstimatedOccupants() * ALLOTTED_PER_DAY * NO_OF_DAYS;
        Optional<Integer> noOfGuests = Optional.ofNullable(allotWater.getNoOFGuest());
        Integer waterConsumptionForGuests = noOfGuests.orElse(0) * ALLOTTED_PER_DAY * NO_OF_DAYS;
        finalBill.setTotalWaterConsumed(waterConsumptionForOccupants + waterConsumptionForGuests);

        occupantsBill = getWaterBillForOccupants(waterConsumptionForOccupants, allotWater);
        tankerBill = getSlabRateBill(waterConsumptionForGuests, TANKER);

        finalBillAmount = occupantsBill + tankerBill;
        finalBill.setTotalCost((int) finalBillAmount);

        return finalBill;
    }


    public Double getFlatRate(String waterDistributionMethod, double waterVolume) {
        Map<String, List<Rate>> map = WaterDistributionRepo.getDistrubutionRates();
        List<Rate> rates = map.get(waterDistributionMethod);
        Rate rate = rates.stream().filter(r -> waterVolume >= r.getVolume().getMin())
                .filter(r -> waterVolume <= r.getVolume().getMax())
                .findFirst()
                .get();
        return rate.getRate();

    }

    private WaterRatio generateRation(String ratio) {
        String[] waterRatioArr = ratio.split(":");
        WaterRatio wr = new WaterRatio();
        wr.setCorporation(Double.valueOf(waterRatioArr[0]));
        wr.setBorewell(Double.valueOf(waterRatioArr[1]));
        return wr;
    }

    public Double getWaterBillForOccupants(Integer occupantsWaterConsumption, AllotWater allotWater) {
        double corporationWaterVolume;
        double corporateWaterRate;
        double borewellWaterVolume;
        double borewellWaterRate;
        double stageOneBill;
        WaterRatio wr = generateRation(allotWater.getWaterRatio());

        corporationWaterVolume = occupantsWaterConsumption * (wr.getCorporation() / (wr.getCorporation() + wr.getBorewell()));
        corporateWaterRate = getFlatRate(CORPORATION.toString(), corporationWaterVolume);

        borewellWaterVolume = occupantsWaterConsumption * (wr.getBorewell() / (wr.getCorporation() + wr.getBorewell()));
        borewellWaterRate = getFlatRate(BOREWELL.toString(), borewellWaterVolume);

        stageOneBill = (corporationWaterVolume * corporateWaterRate) + (borewellWaterVolume * borewellWaterRate);
        return stageOneBill;
    }

    public Double getSlabRateBill(Integer waterConsumption, WaterDistributionMethods waterDistributionMethod) {
        Map<String, List<Rate>> map = WaterDistributionRepo.getDistrubutionRates();
        List<Rate> rates = map.get(waterDistributionMethod.toString());
        double tankerBill = 0d;
        double variableWaterConsumption = waterConsumption;
        double levelConsumption;
        for (int i = rates.size() - 1; i >= 0; i--) {
            if (rates.get(i).getVolume().getMax() >= variableWaterConsumption && rates.get(i).getVolume().getMin() <= variableWaterConsumption) {
                levelConsumption = variableWaterConsumption - rates.get(i).getVolume().getMin();
                variableWaterConsumption = variableWaterConsumption - levelConsumption;
                tankerBill += (levelConsumption) * rates.get(i).getRate();
            }
        }
        return tankerBill;
    }

    /*
    *   r.add(new Rate(new WaterLimit(0,500),2d));
        r.add(new Rate(new WaterLimit(500,1500),3d));
        r.add(new Rate(new WaterLimit(1500,3000),5d));
        r.add(new Rate(new WaterLimit(3000,20000),8d));
    *
    *
    * */

}
