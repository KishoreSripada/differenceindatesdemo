package com.kishore.utilities;

import com.kishore.utilities.controller.CustomDateControllerTest;
import com.kishore.utilities.model.CustomDateTest;
import com.kishore.utilities.service.CustomDateServiceTest;
import com.kishore.utilities.validator.ParameterValidatorTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
        CustomDateControllerTest.class,
        CustomDateServiceTest.class,
        ParameterValidatorTest.class,
        CustomDateTest.class
})

public class AllTestsSuite {
}