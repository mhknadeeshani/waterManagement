package com.fabric.waterManagement.service;

import com.fabric.waterManagement.enums.Action;
import com.fabric.waterManagement.exceptions.InvalidFileNameException;
import com.fabric.waterManagement.model.AllotWater;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.fabric.waterManagement.util.Constants.INVALID_FILE;

public class FileReaderService {

    private static final Logger LOGGER = Logger.getLogger(FileReaderService.class.getName());

    public AllotWater readFile(String filePath) {

        AllotWater allotWater = new AllotWater();
        InputProcessingService inputProcessingService = new InputProcessingService();
        if (filePath.isEmpty()) {
            throw new InvalidFileNameException(INVALID_FILE);
        }

        try {
            File file = new File(filePath);
            Scanner sc = new Scanner(file);

            int noOfGuest = 0;
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] inputColumns = line.split(" ");
                Action actionType = inputProcessingService.generateAction(inputColumns[0]);

                switch (actionType) {
                    case ALLOT_WATER:
                        allotWater.setApartmentType(inputColumns[1]);
                        allotWater.setWaterRatio(inputColumns[2]);
                        break;
                    case ADD_GUESTS:
                        noOfGuest += Integer.parseInt(inputColumns[1]);
                        allotWater.setNoOFGuest(noOfGuest);
                        break;
                    case BILL:
                    case NO_ACTION:
                        break;
                    default:
                        LOGGER.log(Level.SEVERE, "Please check the input format");
                }
            }
        } catch (FileNotFoundException e) {
            LOGGER.log(Level.SEVERE, "FileNotFoundException occurred while reading file");
        } catch (Exception e){
            LOGGER.log(Level.SEVERE, "Exception occurred while reading file" +e);
        }
        return allotWater;
    }

}
