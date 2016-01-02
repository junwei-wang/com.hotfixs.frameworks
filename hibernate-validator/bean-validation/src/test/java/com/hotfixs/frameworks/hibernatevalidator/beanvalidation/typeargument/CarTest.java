package com.hotfixs.frameworks.hibernatevalidator.beanvalidation.typeargument;

import static org.junit.Assert.assertEquals;

import org.hibernate.validator.HibernateValidator;
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
    public static void setUp() {
        ValidatorFactory factory = Validation.byProvider(HibernateValidator.class)
                .configure()
                .addValidatedValueHandler(new GearBoxUnwrapper())
                .buildValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void validateListTypeArgumentConstraint() {
        Car car = new Car();
        car.addPart("Wheel");
        car.addPart(null);

        Set<ConstraintViolation<Car>> constraintViolations = validator.validate(car);

        assertEquals(1, constraintViolations.size());
        assertEquals("'null' is not a valid car part.", constraintViolations.iterator().next().getMessage());
        assertEquals("parts[1]", constraintViolations.iterator().next().getPropertyPath().toString());
    }

    @Test
    public void validateMapTypeArgumentConstraint() {
        Car car = new Car();
        car.setFuelConsumption(Car.FuelConsumption.HIGHWAY, 20);

        Set<ConstraintViolation<Car>> constraintViolations = validator.validate(car);

        assertEquals(1, constraintViolations.size());
        assertEquals("20 is outside the max fuel consumption.", constraintViolations.iterator().next().getMessage());
    }

    @Test
    public void validateOptionalTypeArgumentConstraint() {
        Car car = new Car();
        car.setTowingCapacity(100);

        Set<ConstraintViolation<Car>> constraintViolations = validator.validate(car);

        assertEquals(1, constraintViolations.size());
        assertEquals("Not enough towing capacity.", constraintViolations.iterator().next().getMessage());
        assertEquals("towingCapacity", constraintViolations.iterator().next().getPropertyPath().toString());
    }

    @Test
    public void validateCustomTypeArgumentConstraint() {
        Car car = new Car();
        car.setGearBox(new GearBox<>(new Gear.AcmeGear()));

        Set<ConstraintViolation<Car>> constraintViolations = validator.validate(car);
        assertEquals(1, constraintViolations.size());
        assertEquals("Gear is not providing enough torque.", constraintViolations.iterator().next().getMessage());
        assertEquals("gearBox", constraintViolations.iterator().next().getPropertyPath().toString());
    }
}