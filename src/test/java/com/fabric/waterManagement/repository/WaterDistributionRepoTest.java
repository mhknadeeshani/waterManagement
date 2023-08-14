package com.fabric.waterManagement.repository;

import com.fabric.waterManagement.enums.WaterDistributionMethod;
import com.fabric.waterManagement.model.Rate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

public class WaterDistributionRepoTest {



    @Test
    public void getDistributionRates() {
        Map<WaterDistributionMethod, List<Rate>> waterDistributionMethods = WaterDistributionRepo.getDistributionRates();
        Assertions.assertNotNull(waterDistributionMethods);
        Assertions.assertEquals(waterDistributionMethods.size(), 3);
    }

    @Test
    public void findByValidMethod() {
        WaterDistributionMethod waterDistributionMethod = WaterDistributionMethod.BOREWELL;
        List<Rate> boreWellRates = WaterDistributionRepo.findByDistributionMethod(waterDistributionMethod);
        Assertions.assertNotNull(boreWellRates);
        Assertions.assertEquals(boreWellRates.size(), 1);
    }

}
