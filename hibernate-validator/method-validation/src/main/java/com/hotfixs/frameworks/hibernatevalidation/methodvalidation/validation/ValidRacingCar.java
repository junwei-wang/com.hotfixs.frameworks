package com.hotfixs.frameworks.hibernatevalidation.methodvalidation.validation;

/**
 * @author wangjunwei
 */

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;

@Target({METHOD, CONSTRUCTOR, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = {ValidRacingCar.Validator.class})
@Documented
public @interface ValidRacingCar {

    String message() default "{to.be.filled.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    public static class Validator implements ConstraintValidator<ValidRacingCar, Car> {
        @Override
        public void initialize(ValidRacingCar constraintAnnotation) {
        }

        @Override
        public boolean isValid(Car car, ConstraintValidatorContext context) {
            return false;
        }
    }
}
