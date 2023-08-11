package com.fabric.waterManagement.service;

import com.fabric.waterManagement.model.AllotWater;
import com.fabric.waterManagement.model.Bill;

public class WaterManagementService {

    public String billGeneration(String filePath) {
        FileReaderService fileReaderService = new FileReaderService();
        BillService billService = new BillService();
        AllotWater allotWater = fileReaderService.readFile(filePath);
        Bill bill = billService.generateFinalBill(allotWater);
        return bill.getTotalWaterConsumed() + " " + bill.getTotalCost();
    }
}

