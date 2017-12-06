package com.kishore.utilities.model;

public enum Month {
    JANUARY(31),
    FEBRUARY(28),
    MARCH(31),
    APRIL(30),
    MAY(31),
    JUNE(30),
    JULY(31),
    AUGUST(31),
    SEPTEMBER(30),
    OCTOBER(31),
    NOVEMBER(30),
    DECEMBER(31);

    private final int noOfDays;

    Month(int noOfDays) {
        this.noOfDays = noOfDays;
    }

    public int getNoOfDays() {
        return noOfDays;
    }

    public int getMonth() {
        return ordinal() + 1;
    }

    public static Month getNumericValueForMonth(int month) {
        return Month.values()[month-1];
    }

    public int differenceInDays(Month month) {
        if (month == this) {
            return 0;
        } else if (month.earlierThan(this)) {
            return -month.differenceInDays(this);
        }
        return calculateNoOfDays(this, month);
    }

    private static int calculateNoOfDays(Month before, Month after) {
        int days = 0;
        while (before.earlierThan(after)) {
            days += before.noOfDays;
            before = before.next();
        }
        return days;
    }

    private boolean earlierThan(Month month) {
        return this.ordinal() < month.ordinal();
    }

    private Month next() {
        return Month.getNumericValueForMonth(this.getMonth() + 1);
    }
}