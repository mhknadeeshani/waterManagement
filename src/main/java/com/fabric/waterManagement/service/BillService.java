package com.fabric.waterManagement.service;

import com.fabric.waterManagement.enums.WaterDistributionMethod;
import com.fabric.waterManagement.model.*;
import com.fabric.waterManagement.repository.ApartmentWaterConsumptionRepo;
import com.fabric.waterManagement.repository.WaterDistributionRepo;

import java.util.List;
import java.util.Optional;

import static com.fabric.waterManagement.enums.WaterDistributionMethod.*;
import static com.fabric.waterManagement.util.Constants.ALLOTTED_PER_DAY;
import static com.fabric.waterManagement.util.Constants.NO_OF_DAYS;

public class BillService {


    public Bill generateFinalBill(AllotWater allotWater) {
        Double occupantsBill;
        Double tankerBill;
        Bill finalBill = new Bill();
        double finalBillAmount;

        int apartmentType = Integer.parseInt(allotWater.getApartmentType());

        Integer waterConsumptionForOccupants = Optional.ofNullable(ApartmentWaterConsumptionRepo.findByType(apartmentType))
                .orElse(new Apartment(0, 0)).getEstimatedOccupants() * ALLOTTED_PER_DAY * NO_OF_DAYS;

        Optional<Integer> noOfGuests = Optional.ofNullable(allotWater.getNoOFGuest());
        Integer waterConsumptionForGuests = noOfGuests.orElse(0) * ALLOTTED_PER_DAY * NO_OF_DAYS;

        finalBill.setTotalWaterConsumed(waterConsumptionForOccupants + waterConsumptionForGuests);

        occupantsBill = getWaterBillForOccupants(waterConsumptionForOccupants, allotWater);
        tankerBill = getSlabRateBill(waterConsumptionForGuests, TANKER);
        finalBillAmount = occupantsBill + tankerBill;

        finalBill.setTotalCost((int) finalBillAmount);

        return finalBill;
    }


    public Double getFlatRate(WaterDistributionMethod waterDistributionMethod, double waterVolume) {
        List<Rate> rates = WaterDistributionRepo.findByDistributionMethod(waterDistributionMethod);
        Rate rate = rates.stream().filter(r -> waterVolume >= r.getVolume().getMin())
                .filter(r -> waterVolume <= r.getVolume().getMax())
                .findFirst()
                .get();
        return rate.getRate();

    }



    public Double getWaterBillForOccupants(Integer occupantsWaterConsumption, AllotWater allotWater) {
        double corporationWaterVolume;
        double corporateWaterRate;
        double borewellWaterVolume;
        double borewellWaterRate;
        double stageOneBill;
        InputProcessingService inputProcessingService = new InputProcessingService();
        WaterRatio wr = inputProcessingService.generateRatio(allotWater.getWaterRatio());

        corporationWaterVolume = occupantsWaterConsumption * (wr.getCorporation() / (wr.getCorporation() + wr.getBoreWell()));
        corporateWaterRate = getFlatRate(CORPORATION, corporationWaterVolume);

        borewellWaterVolume = occupantsWaterConsumption * (wr.getBoreWell() / (wr.getCorporation() + wr.getBoreWell()));
        borewellWaterRate = getFlatRate(BOREWELL, borewellWaterVolume);

        stageOneBill = (corporationWaterVolume * corporateWaterRate) + (borewellWaterVolume * borewellWaterRate);
        return stageOneBill;
    }

    public Double getSlabRateBill(Integer waterConsumption, WaterDistributionMethod waterDistributionMethod) {
        List<Rate> rates = WaterDistributionRepo.findByDistributionMethod(waterDistributionMethod);
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

    public String billGeneration(String filePath) {
        FileReaderService fileReaderService = new FileReaderService();
        BillService billService = new BillService();
        AllotWater allotWater = fileReaderService.readFile(filePath);
        Bill bill = billService.generateFinalBill(allotWater);
        return bill.getTotalWaterConsumed() + " " + bill.getTotalCost();
    }
}
