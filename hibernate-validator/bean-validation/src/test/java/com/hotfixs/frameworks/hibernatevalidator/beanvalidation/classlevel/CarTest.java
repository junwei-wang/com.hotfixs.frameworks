package com.hotfixs.frameworks.hibernatevalidator.beanvalidation.classlevel;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 * @author wangjunwei
 */
public class CarTest {
    private static Validator validator;

    @BeforeClass
    public static void setUpValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void validate() {
        Car car = new Car();
        Set<ConstraintViolation<Car>> constraintValidators = validator.validate(car);
        assertEquals(1, constraintValidators.size());
        assertEquals("passenger number must be less than the capacity.",
                constraintValidators.iterator().next().getMessage());
    }
}