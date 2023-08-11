package com.fabric.waterManagement.service;

import com.fabric.waterManagement.exceptions.InvalidFileNameException;
import com.fabric.waterManagement.model.AllotWater;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class FileReaderTest {


    FileReaderService fileReaderService;
    AllotWater allotWater;

    @BeforeEach
    public void setUp() {
        fileReaderService = new FileReaderService();
        allotWater = new AllotWater();
        allotWater.setWaterRatio("3:7");
        allotWater.setApartmentType("2");
        allotWater.setNoOFGuest(5);

    }

    @Test
    public void invalidFilePathTest() {
        Assertions.assertThrows(InvalidFileNameException.class, () -> {
            fileReaderService.readFile("");
        }, "InvalidFileNameException was expected");
    }

    @Test
    public void readFileTest() {
        String filePath = "src/test/resources/testCase1.txt";
        AllotWater result = fileReaderService.readFile(filePath);
        Assertions.assertEquals(allotWater, result);
    }


}
