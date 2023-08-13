package com.fabric.waterManagement.service;

import com.fabric.waterManagement.exceptions.InvalidInputException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InputProcessingServiceTest {

    InputProcessingService inputProcessingService;

    @BeforeEach
    public void setUp() {
        inputProcessingService = new InputProcessingService();
    }

    @Test
    public void generateActionTest() {
        String input = "TEST";
        Assertions.assertThrows(InvalidInputException.class, () -> inputProcessingService.generateAction(input));
    }

}
