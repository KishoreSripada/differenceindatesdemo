package com.kishore.utilities.service;

import com.kishore.utilities.model.CustomDate;
import com.kishore.utilities.model.Month;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;
import java.util.ArrayList;
import java.util.List;

public class CustomDateServiceTest {

    @InjectMocks
    private CustomDateService customDateService = new CustomDateService();

    private List<CustomDate> setup_valid_customdate_data() {
        List<CustomDate> customDateList = new ArrayList<>();
        customDateList.add(new CustomDate(12, Month.getNumericValueForMonth(5), 2001));
        customDateList.add(new CustomDate(14, Month.getNumericValueForMonth(5), 2001));
        return customDateList;
    }

    private List<CustomDate> setup_invalid_customdate_data() {
        List<CustomDate> customDateList = new ArrayList<>();
        customDateList.add(new CustomDate(12, Month.getNumericValueForMonth(5), 2001));
        customDateList.add(new CustomDate(34, Month.getNumericValueForMonth(55), 2001));
        return customDateList;
    }

    @Test
    public void test_when_input_is_correct_return_difference_in_days() {
        int differenceInDays = customDateService.getDifferenceInDays(setup_valid_customdate_data());
        Assert.assertEquals(differenceInDays, 2);
    }

    @Test(expected = Exception.class)
    public void test_when_input_is_incorrect_then_throw_Exception() {
        customDateService.getDifferenceInDays(setup_invalid_customdate_data());
    }

    @Test
    public void test_when_input_is_null_then_return_negative_1() {
        int differenceInDays = customDateService.getDifferenceInDays(null);
        Assert.assertEquals(differenceInDays, -1);
    }
}