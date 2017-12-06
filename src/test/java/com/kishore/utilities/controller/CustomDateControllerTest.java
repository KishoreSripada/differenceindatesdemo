package com.kishore.utilities.controller;

import com.kishore.utilities.service.CustomDateService;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;

import java.util.List;

public class CustomDateControllerTest {

    @InjectMocks
    private CustomDateService dateService = new CustomDateService();

    @InjectMocks
    private CustomDateController dateController = new CustomDateController(dateService);

    @Test
    public void when_valid_input_is_passed_return_list_with_dates_and_difference_days() {
        List returnList = dateController.getDifferenceInDate("22 05 2005", "24 05 2005");
        Assert.assertEquals("22 05 2005", returnList.get(0));
        Assert.assertEquals("24 05 2005", returnList.get(1));
        Assert.assertEquals(new Long(2), returnList.get(2));
    }

    @Test
    public void when_invalid_day_input_is_passed_return_list_with_relevant_exception() {
        List returnList = dateController.getDifferenceInDate("22 05 2005", "34 05 2005");
        Assert.assertEquals("Day can only contain values between 1 and 31 found value:34", returnList.get(0));
    }

    @Test
    public void when_invalid_month_input_is_passed_return_list_with_relevant_exception() {
        List returnList = dateController.getDifferenceInDate("22 05 2005", "34 15 2005");
        Assert.assertEquals("Month can only contain values between 1 and 12 found value:15", returnList.get(0));
    }

    @Test
    public void when_invalid_year_input_is_passed_return_list_with_relevant_exception() {
        List returnList = dateController.getDifferenceInDate("22 05 2015", "34 15 2005");
        Assert.assertEquals("Year can only contain values between 1900 and 2010 found value:2015", returnList.get(0));
    }

    @Test
    public void when_invalid_pattern_ddmm_yyyy_input_is_passed_return_list_with_relevant_exception() {
        List returnList = dateController.getDifferenceInDate("2205 2005", "34 05 2005");
        Assert.assertEquals("Expected to be of form 'DD MM YYYY', found '2205 2005'", returnList.get(0));
    }

    @Test
    public void when_invalid_pattern_with_slash_input_is_passed_return_list_with_relevant_exception() {
        List returnList = dateController.getDifferenceInDate("22/05/2005", "34 05 2005");
        Assert.assertEquals("Expected to be of form 'DD MM YYYY', found '22/05/2005'", returnList.get(0));
    }
}