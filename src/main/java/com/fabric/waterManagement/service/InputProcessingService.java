package com.fabric.waterManagement.service;

import com.fabric.waterManagement.enums.Action;
import com.fabric.waterManagement.exceptions.InvalidInputException;
import com.fabric.waterManagement.model.WaterRatio;

import java.util.logging.Level;
import java.util.logging.Logger;

public class InputProcessingService {

    private static final Logger LOGGER = Logger.getLogger(InputProcessingService.class.getName());

    public Action generateAction(String inputDistributionMethod){
        Action distributionType = Action.NO_ACTION;
        try {
            distributionType = Action.valueOf(inputDistributionMethod);
        }catch(IllegalArgumentException e){
            LOGGER.log(Level.SEVERE, "Invalid input argument. Please validate the input file");
            throw new InvalidInputException("Invalid input argument. Please validate the input file");
        }
        return distributionType;
    }

    public WaterRatio generateRatio(String ratio) {
        String[] waterRatioArr = ratio.split(":");
        WaterRatio wr = new WaterRatio();
        wr.setCorporation(Double.valueOf(waterRatioArr[0]));
        wr.setBoreWell(Double.valueOf(waterRatioArr[1]));
        return wr;}
}

