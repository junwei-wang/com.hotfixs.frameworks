package com.hotfixs.frameworks.hibernatevalidator.customconstraints.crossparameter;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ScriptAssertObjectValidator implements ConstraintValidator<ScriptAssert, Object> {

    @Override
    public void initialize(ScriptAssert constraintAnnotation) {
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        return false;
    }
}
