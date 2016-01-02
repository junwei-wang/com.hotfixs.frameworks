package com.hotfixs.frameworks.hibernatevalidation.methodvalidation.crossparameter;

/**
 * @author wangjunwei
 */

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.ConstraintTarget;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import javax.validation.constraintvalidation.SupportedValidationTarget;
import javax.validation.constraintvalidation.ValidationTarget;

@Target({METHOD, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = {LuggageCountMatchesPassengerCount.Validator.class})
@Documented
public @interface LuggageCountMatchesPassengerCount {

    String message() default "{com.hotfixs.frameworks.hibernatevalidator.methodvalidation..MaxAllowedFuelConsumption"
            + ".crossparameter.LuggageCounterMatchesPassengerCount.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    ConstraintTarget validationAppliesTo() default ConstraintTarget.IMPLICIT;

    int piecesOfLuggagePerPassenger() default 1;

    @SupportedValidationTarget({ValidationTarget.PARAMETERS, ValidationTarget.ANNOTATED_ELEMENT})
    class Validator implements ConstraintValidator<LuggageCountMatchesPassengerCount, Object[]> {
        @Override
        public void initialize(LuggageCountMatchesPassengerCount constraintAnnotation) {
        }

        @Override
        public boolean isValid(Object[] value, ConstraintValidatorContext context) {
            return false;
        }
    }
}
