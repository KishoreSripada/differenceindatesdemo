package com.kishore.utilities.service;

import com.kishore.utilities.model.CustomDate;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomDateService {

    public int getDifferenceInDays(List<CustomDate> customDateList) {
        int differenceInDays = -1;
        if (null!=customDateList && !customDateList.isEmpty() && customDateList.size()==2)
            differenceInDays =  customDateList.get(0).fetchDifferenceInDays(customDateList.get(1));
        return differenceInDays;
    }
}