package com.hotfixs.frameworks.hibernatevalidator.beanvalidation.inheritance;

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
public class RentalCarTest {
    private static Validator validator;

    @BeforeClass
    public static void setUpValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void validate() {
        RentalCar car = new RentalCar();
        Set<ConstraintViolation<RentalCar>> constraintValidators = validator.validate(car);
        assertEquals(2, constraintValidators.size());
    }
}