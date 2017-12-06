package com.kishore.utilities.model;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CustomDateTest {

    private static final CustomDate TODAY = new CustomDate(7, Month.DECEMBER, 2007);
    private static final CustomDate TOMORROW = new CustomDate(8, Month.DECEMBER, 2007);
    private static final CustomDate NOV_27TH_2010 = new CustomDate(27, Month.NOVEMBER, 2010);
    private static final CustomDate DEC_2ND = new CustomDate(2, Month.DECEMBER, 2010);
    private static final CustomDate FEBRUARY_1ST = new CustomDate(1, Month.FEBRUARY, 2010);
    private static final CustomDate MARCH_1ST = new CustomDate(1, Month.MARCH, 2010);
    private static final CustomDate JAN_1ST_2001 = new CustomDate(1, Month.JANUARY, 2001);
    private static final CustomDate JAN_1ST_2002 = new CustomDate(1, Month.JANUARY, 2002);
    private static final CustomDate DEC_31ST_2001 = new CustomDate(31, Month.DECEMBER, 2001);

    @Test
    public void when_input_is_today_and_tomorrow_should_return_1() {
        assertThat(TODAY.fetchDifferenceInDays(TOMORROW), is(1));
    }

    @Test
    public void when_input_is_month_should_return_month_difference() {
        assertThat(FEBRUARY_1ST.fetchDifferenceInDays(MARCH_1ST), is(28));
    }

    @Test
    public void when_input_is_months_should_return_exact_difference_of_days() {
        assertThat(NOV_27TH_2010.fetchDifferenceInDays(DEC_2ND), is(5));
    }

    @Test
    public void when_input_is_year_should_return_difference_of_days_as_per_year() {
        assertThat(JAN_1ST_2001.fetchDifferenceInDays(JAN_1ST_2002), is(365));
    }

    @Test
    public void output_should_always_have_dd_mm_yyyy_pattern() {
        assertThat(DEC_31ST_2001.toString(), is("31 12 2001"));
    }

    @Test
    public void output_is_considered_positive_always() {
        assertThat(TODAY.fetchDifferenceInDays(TOMORROW), is(1));
        assertThat(TOMORROW.fetchDifferenceInDays(TODAY), is(1));
    }
}