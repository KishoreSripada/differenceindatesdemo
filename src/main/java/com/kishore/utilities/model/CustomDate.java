package com.kishore.utilities.model;

import static java.lang.Math.abs;

public class CustomDate {
    private final int day;
    private final Month month;
    private final int year;

    public CustomDate(int day, Month month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int fetchDifferenceInDays(CustomDate second) {
        return abs(populateDifferenceInDays(second) + populateDifferenceInMonths(second) + populateDifferenceInYears(second));
    }

    private int populateDifferenceInDays(CustomDate second) {
        return (second.day - this.day);
    }

    private int populateDifferenceInMonths(CustomDate second) {
        return month.differenceInDays(second.month);
    }

    private int populateDifferenceInYears(CustomDate second) {
        return (365 * (second.year - this.year));
    }

    @Override
    public String toString() {
        return String.format("%s %s %d", padFill_Zeroes_For_Days_And_Months_LessThan_10(day), padFill_Zeroes_For_Days_And_Months_LessThan_10(month.getMonth()), year);
    }

    public int getDay() {
        return day;
    }

    public Month getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    private String padFill_Zeroes_For_Days_And_Months_LessThan_10(int value) {
        return String.format((value < 10) ? "0%d" : "%d", value);
    }
}