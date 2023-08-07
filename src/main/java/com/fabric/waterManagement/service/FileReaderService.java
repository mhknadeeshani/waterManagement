package com.fabric.waterManagement.service;

import com.fabric.waterManagement.enums.Action;
import com.fabric.waterManagement.enums.ApartmentType;
import com.fabric.waterManagement.model.AllotWater;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileReaderService {

    private static final Logger LOGGER = Logger.getLogger(FileReaderService.class.getName());

    public static void readFile () throws FileNotFoundException {
        File file = new File("src/main/resources/static/test.txt");
        Scanner sc = new Scanner(file);
        AllotWater allotWater = new AllotWater();
        int noOfGuest =0;
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String [] inputColumns = line.split(" ");
            if (Action.ALLOT_WATER.toString().equals(inputColumns[0])) {
                allotWater.setApartmentType(inputColumns[1]);
                allotWater.setWaterRatio(inputColumns[2]);
                //System.out.println(sc.next());
                //System.out.println(sc.next());
            }
            if (Action.ADD_GUESTS.toString().equals(inputColumns[0])){
                noOfGuest += Integer.parseInt(inputColumns[1]);
                allotWater.setNoOFGuest(noOfGuest);
                System.out.println(noOfGuest);
            }
            if (Action.BILL.toString().equals(inputColumns[0])){
                BillService billService = new BillService();
                System.out.println(allotWater);
                billService.generateBill(allotWater);
            }
            /*else{
                LOGGER.log(Level.SEVERE, "Please check the input format");
            }*/
        }
    }

}
