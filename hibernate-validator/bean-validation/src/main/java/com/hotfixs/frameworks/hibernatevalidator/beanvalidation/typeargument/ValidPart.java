package com.hotfixs.frameworks.hibernatevalidator.beanvalidation.typeargument;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE_USE;
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
@Documented
@Constraint(validatedBy = {ValidPart.ValidPartValidator.class})
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
public @interface ValidPart {
    String message() default "{com.hotfixs.frameworks.hibernatevalidator.beanvalidation.typeargument.ValidPart.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    class ValidPartValidator implements ConstraintValidator<ValidPart, String> {
        @Override
        public void initialize(ValidPart annotation) {
        }

        @Override
        public boolean isValid(String value, ConstraintValidatorContext context) {
            return value != null;
        }
    }
}
