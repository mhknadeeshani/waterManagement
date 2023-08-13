package com.fabric.waterManagement;


import com.fabric.waterManagement.service.BillService;

import static com.fabric.waterManagement.util.Constants.FILE_PATH;

public class WaterManagementApplication {


    public static void main(String[] args) {
        String filePath = args.length > 0 ? args[0] : FILE_PATH;
        BillService billService = new BillService();
        String bill = billService.billGeneration(filePath);
        System.out.println(bill);
    }

}
