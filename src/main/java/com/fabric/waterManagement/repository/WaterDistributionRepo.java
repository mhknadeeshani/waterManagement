package com.fabric.waterManagement.repository;

import com.fabric.waterManagement.enums.WaterDistributionMethods;
import com.fabric.waterManagement.model.Rate;
import com.fabric.waterManagement.model.WaterDistributionType;
import com.fabric.waterManagement.model.WaterLimit;
import java.util.ArrayList;
import java.util.List;


public class WaterDistributionRepo {

    public List<WaterDistributionType> getDistrubutionRates(){
        List<WaterDistributionType> distributionList = new ArrayList();
        List<Rate> r = new ArrayList<>();
        Rate r1 = new Rate(new WaterLimit(0,1500),1);
        r.add(r1);
        distributionList.add(new WaterDistributionType(WaterDistributionMethods.CORPORATION.toString(), r ));
        distributionList.add(new WaterDistributionType(WaterDistributionMethods.BOREWELL.toString(), r));

        return distributionList;
    }
}
