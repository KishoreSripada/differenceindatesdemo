package com.kishore.utilities.validator;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.runners.JUnit44RunnerImpl;

import static org.mockito.Mockito.mock;

public class ParameterValidatorTest {

    @InjectMocks
    ParameterValidator validator = new ParameterValidator();

    // Positive Test Scenarios
    @Test
    public void test_input_having_correct_date_format() {
        Assert.assertEquals(validator.validate("01 01 2011"), true);
    }

    @Test
    public void validate_date_valid_input() throws Exception {
        int value = validator.validate_Day_Month_Year("Day", 23,1,30);
        Assert.assertEquals(value, 23);
    }

    @Test
    public void validate_month_valid_input() throws Exception {
        int value = validator.validate_Day_Month_Year("Month", 12,1,12);
        Assert.assertEquals(value, 12);
    }

    @Test
    public void validate_year_valid_input() throws Exception {
        int value = validator.validate_Day_Month_Year("Year", 2004,1900,2010);
        Assert.assertEquals(value, 2004);
    }

    // Exception Test Scenarios
    @Test(expected = IllegalArgumentException.class)
    public void test_input_having_incorrect_date_format() {
        Assert.assertEquals(validator.validate("01012011"), false);
    }

    @Test(expected = Exception.class)
    public void validate_date_out_of_range() throws Exception {
        validator.validate_Day_Month_Year("Day", 33,1,30);
    }

    @Test(expected = Exception.class)
    public void validate_month_out_of_range() throws Exception {
        validator.validate_Day_Month_Year("Month", 22,1,12);
    }

    @Test(expected = Exception.class)
    public void validate_year_out_of_range() throws Exception {
        validator.validate_Day_Month_Year("Year", 2014,1900,2010);
    }

}