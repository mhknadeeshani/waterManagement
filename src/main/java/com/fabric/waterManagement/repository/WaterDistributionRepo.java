package com.fabric.waterManagement.repository;

import com.fabric.waterManagement.enums.WaterDistributionMethods;
import com.fabric.waterManagement.model.Rate;
import com.fabric.waterManagement.model.WaterLimit;

import java.util.*;


public class WaterDistributionRepo {

    public static Map<String, List<Rate>> getDistrubutionRates() {
        Map<String, List<Rate>> waterRateMap = new HashMap<>();
        waterRateMap.put(WaterDistributionMethods.CORPORATION.toString(), Arrays.asList(new Rate(new WaterLimit(0, 1500), 1d)));
        waterRateMap.put(WaterDistributionMethods.BOREWELL.toString(), Arrays.asList(new Rate(new WaterLimit(0, 1500), 1.5d)));
        List<Rate> r = new ArrayList<>();
        r.add(new Rate(new WaterLimit(0, 500), 2d));
        r.add(new Rate(new WaterLimit(500, 1500), 3d));
        r.add(new Rate(new WaterLimit(1500, 3000), 5d));
        r.add(new Rate(new WaterLimit(3000, 20000), 8d));
        waterRateMap.put(WaterDistributionMethods.TANKER.toString(), r);
        return waterRateMap;
    }
}
