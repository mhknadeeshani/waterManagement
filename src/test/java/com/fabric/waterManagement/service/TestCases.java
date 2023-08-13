package com.fabric.waterManagement.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestCases {


    BillService billService;
    String filePath1 = "src/test/resources/testCase1.txt";
    String filePath2 = "src/test/resources/testCase2.txt";
    String filePath3 = "src/test/resources/testCase3.txt";

    @BeforeEach
    public void setUp() {
        billService = new BillService();
    }

    @Test
    public void testCase1() {
        String result = billService.billGeneration(filePath1);
        Assertions.assertEquals(result, "2400 5215");
    }

    @Test
    public void testCase2() {
        String result = billService.billGeneration(filePath2);
        Assertions.assertEquals(result, "3000 5750");
    }

    @Test
    public void testCase3() {
        String result = billService.billGeneration(filePath3);
        Assertions.assertEquals(result, "900 1200");
    }
}
