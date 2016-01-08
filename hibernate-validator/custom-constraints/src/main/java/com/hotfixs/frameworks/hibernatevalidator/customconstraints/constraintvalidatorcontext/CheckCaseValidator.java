package com.hotfixs.frameworks.hibernatevalidator.customconstraints.constraintvalidatorcontext;

import com.hotfixs.frameworks.hibernatevalidator.customconstraints.CaseMode;
import com.hotfixs.frameworks.hibernatevalidator.customconstraints.CheckCase;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */
public class CheckCaseValidator implements ConstraintValidator<CheckCase, String> {
    private CaseMode caseMode;

    @Override
    public void initialize(CheckCase constraintAnnotation) {
        this.caseMode = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        boolean isValid;

        if (value == null) {
            isValid = true;
        }

        if (caseMode == CaseMode.UPPER) {
            isValid = value.equals(value.toUpperCase());
        } else {
            isValid = value.equals(value.toLowerCase());
        }

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(
                    "case should be {value}"
            ).addConstraintViolation();
        }

        return isValid;
    }
}
