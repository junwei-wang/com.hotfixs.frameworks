package com.hotfixs.frameworks.hibernatevalidator.beanvalidation.classlevel;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;

/**
 * @author wangjunwei
 */
@Target({TYPE, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = {ValidPassengerCount.Validator.class})
@Documented
public @interface ValidPassengerCount {

    String message() default "{com.hotfixs.frameworks.hibernatevalidator.beanvalidation.classlevel"
            + ".ValidPassengerCount.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    class Validator implements ConstraintValidator<ValidPassengerCount, Car> {
        @Override
        public void initialize(ValidPassengerCount constraintAnnotation) {
        }

        @Override
        public boolean isValid(Car car, ConstraintValidatorContext context) {
            return false;
        }
    }
}
