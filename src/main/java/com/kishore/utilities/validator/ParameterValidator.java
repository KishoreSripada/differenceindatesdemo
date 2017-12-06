package com.kishore.utilities.validator;

import java.util.regex.Pattern;

public class ParameterValidator {

    private static final Pattern CORRECT_FORMAT = Pattern.compile("^\\d{2} \\d{2} \\d{4}$");

    public boolean validate(String date) {
        boolean isValidatedSuccessfully;
        if (null==(date) || !isMatchingPattern(date)) {
            throw new IllegalArgumentException(String.format("Expected to be of form 'DD MM YYYY', found '%s'", date));
        } else {
            isValidatedSuccessfully = true;
        }
        return isValidatedSuccessfully;
    }

    private boolean isMatchingPattern(String date) {
        return CORRECT_FORMAT.matcher(date).matches();
    }

    public int validate_Day_Month_Year(String type, int value, int lowerBoundary, int upperBoundary) throws Exception {
        if(value <  lowerBoundary || value > upperBoundary) {
            throw new Exception(type + " can only contain values between " + lowerBoundary + " and " + upperBoundary
            + " found value:" + value);
        }
        return value;
    }
}