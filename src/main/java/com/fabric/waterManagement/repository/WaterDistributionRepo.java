package com.fabric.waterManagement.repository;

import com.fabric.waterManagement.enums.WaterDistributionMethod;
import com.fabric.waterManagement.model.Rate;
import com.fabric.waterManagement.model.WaterLimit;

import java.util.*;


public class WaterDistributionRepo {

    static Map<WaterDistributionMethod, List<Rate>> waterRateMap;

    static {
        waterRateMap = new HashMap<>();
        waterRateMap.put(WaterDistributionMethod.CORPORATION, Arrays.asList(new Rate(new WaterLimit(0, 1500), 1d)));
        waterRateMap.put(WaterDistributionMethod.BOREWELL, Arrays.asList(new Rate(new WaterLimit(0, 1500), 1.5d)));
        List<Rate> r = new ArrayList<>();
        r.add(new Rate(new WaterLimit(0, 500), 2d));
        r.add(new Rate(new WaterLimit(500, 1500), 3d));
        r.add(new Rate(new WaterLimit(1500, 3000), 5d));
        r.add(new Rate(new WaterLimit(3000, 20000), 8d));
        waterRateMap.put(WaterDistributionMethod.TANKER, r);
    }
    public static Map<WaterDistributionMethod, List<Rate>> getDistributionRates() {
        return waterRateMap;
    }

    public static List<Rate> findByDistributionMethod(WaterDistributionMethod waterDistributionMethod){
       return waterRateMap.getOrDefault(waterDistributionMethod,Arrays.asList(new Rate(new WaterLimit(0,0),0d)));
    }

}
