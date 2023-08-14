package com.fabric.waterManagement.service;

import com.fabric.waterManagement.enums.Action;
import com.fabric.waterManagement.exceptions.InvalidInputException;
import com.fabric.waterManagement.model.WaterRatio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InputProcessingServiceTest {

    InputProcessingService inputProcessingService;
    WaterRatio ratio;

    @BeforeEach
    public void setUp() {
        inputProcessingService = new InputProcessingService();
        ratio = new WaterRatio();
        ratio.setCorporation(3d);
        ratio.setBoreWell(7d);
    }

    @Test
    public void generateInvalidActionTest() {
        String input = "TEST";
        Assertions.assertThrows(InvalidInputException.class, () -> inputProcessingService.generateAction(input));
    }

    @Test
    public void generateValidActionTest(){
        String input = "ALLOT_WATER";
        Assertions.assertEquals(Action.ALLOT_WATER,inputProcessingService.generateAction(input));
    }
    @Test
    public void generateRatioTest() {
        String inputRatio = "3:7";
        Assertions.assertEquals(ratio, inputProcessingService.generateRatio(inputRatio));
    }
}
