package com.kishore.utilities.controller;

import com.kishore.utilities.model.CustomDate;
import com.kishore.utilities.model.Month;
import com.kishore.utilities.service.CustomDateService;
import com.kishore.utilities.validator.ParameterValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/DateService")
public class CustomDateController {

    Logger logger = Logger.getLogger(CustomDateController.class.getName());

    @Autowired
    private CustomDateService dateService;

    public CustomDateController(CustomDateService dateService) {
        this.dateService = dateService;
    }

    @RequestMapping("/DifferenceInDates")
    public List<Object> getDifferenceInDate(
            @RequestParam (value="startDate") String startDate,
            @RequestParam (value="endDate") String endDate) {
        logger.log(Level.INFO, "In GET method : getDifferenceInDate");
        List<Object> output = new ArrayList<>();
        try {
            logger.log(Level.INFO, "validating the input parameters");
            validate(startDate, endDate);
            logger.log(Level.INFO, "validate successful");
            List<CustomDate> customDateList = populateDateFields(startDate, endDate);
            logger.log(Level.INFO, "populated customDateFields to find the difference");
            long diffDays = dateService.getDifferenceInDays(customDateList);
            logger.log(Level.INFO, "diffDays is:"+diffDays);
            output.add(startDate);
            output.add(endDate);
            output.add(diffDays);
            return output;
        } catch(Exception ex) {
            logger.log(Level.SEVERE, "Exception occurred:"+ ex.getMessage());
            output.add(ex.getMessage());
            return output;
        }
    }

    private List<CustomDate> populateDateFields(String startDate, String endDate) throws Exception {
        List<CustomDate> customDateList = new ArrayList<>();
        ParameterValidator validator = new ParameterValidator();
        customDateList.add(getCustomDate(startDate, validator));
        customDateList.add(getCustomDate(endDate, validator));
        return customDateList;
    }

    private CustomDate getCustomDate(String startDate, ParameterValidator validator) throws Exception {
        String[] startArray = startDate.split(" ");
        Month startMonth = getMonth(validator, startArray);
        return getCustomDate(validator, startArray, startMonth);
    }

    private Month getMonth(ParameterValidator validator, String[] array) throws Exception {
        return Month.getNumericValueForMonth(validator.validate_Day_Month_Year("Month", Integer.parseInt(array[1]), 1, 12));
    }

    private CustomDate getCustomDate(ParameterValidator validator, String[] array, Month month) throws Exception {
        return new CustomDate(validator.validate_Day_Month_Year("Day", Integer.parseInt(array[0]), 1, month.getNoOfDays()),
                month, validator.validate_Day_Month_Year("Year", Integer.parseInt(array[2]), 1900, 2010));
    }

    private void validate(String startDate, String endDate) {
        ParameterValidator validator = new ParameterValidator();
        validator.validate(startDate);
        validator.validate(endDate);
    }
}