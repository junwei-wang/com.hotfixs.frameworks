package com.hotfixs.frameworks.hibernatevalidation.methodvalidation.returnvalue;

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
@Constraint(validatedBy = {ValidRentalStation.Validator.class})
@Documented
public @interface ValidRentalStation {

    String message() default "{to.be.filled.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    class Validator implements ConstraintValidator<ValidRentalStation, Object[]> {
        @Override
        public void initialize(ValidRentalStation constraintAnnotation) {
        }

        @Override
        public boolean isValid(Object[] value, ConstraintValidatorContext context) {
            return false;
        }
    }
}
