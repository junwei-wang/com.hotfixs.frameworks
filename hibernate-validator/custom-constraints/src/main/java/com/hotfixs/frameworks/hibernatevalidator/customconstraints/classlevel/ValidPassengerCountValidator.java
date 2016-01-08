package com.hotfixs.frameworks.hibernatevalidator.customconstraints.classlevel;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */
public class ValidPassengerCountValidator implements ConstraintValidator<ValidPassengerCount, Car> {
    @Override
    public void initialize(ValidPassengerCount constraintAnnotation) {
    }

    @Override
    public boolean isValid(Car value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        return value.getPassengers().size() <= value.getSeatCount();
    }
}
