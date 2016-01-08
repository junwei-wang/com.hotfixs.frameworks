package com.hotfixs.frameworks.hibernatevalidator.customconstraints.crossparameter;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.NotNull;
import javax.validation.executable.ExecutableValidator;

public class ConsistentDateParametersTest {

    private static ExecutableValidator executableValidator;

    @BeforeClass
    public static void setUpValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        executableValidator = factory.getValidator().forExecutables();
    }

    @Test
    public void testConsistentDateParametersConstraint() throws Exception {
        CalendarService object = new CalendarService();
        Method method = CalendarService.class.getMethod("createCalendarEvent", Date.class, Date.class);

        Calendar start = Calendar.getInstance();
        start.set(2013, 5, 10);
        Calendar end = Calendar.getInstance();
        end.set(2013, 5, 9);
        Object[] parameterValues = new Object[] { start.getTime(), end.getTime() };
        Set<ConstraintViolation<CalendarService>> constraintViolations = executableValidator.validateParameters(
                object,
                method,
                parameterValues
        );

        assertEquals(1, constraintViolations.size());
        assertEquals(
                ConsistentDateParameters.class,
                constraintViolations.iterator().next().getConstraintDescriptor().getAnnotation().annotationType()
        );

        constraintViolations = executableValidator.validateParameters(
                object,
                method,
                new Object[] { end.getTime(), start.getTime() }
        );
        assertEquals(0, constraintViolations.size());
    }

    private static class CalendarService {

        @ConsistentDateParameters
        public void createCalendarEvent(@NotNull Date start, @NotNull Date end) {
            //...
        }
    }
}
