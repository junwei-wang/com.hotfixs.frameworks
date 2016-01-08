package com.hotfixs.frameworks.hibernatevalidator.customconstraints.crossparameter;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.ConstraintTarget;
import javax.validation.Payload;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */

@Constraint(validatedBy = {
        ScriptAssertObjectValidator.class,
        ScriptAssertParametersValidator.class
})
@Target({ TYPE, FIELD, PARAMETER, METHOD, CONSTRUCTOR, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Documented
public @interface ScriptAssert {

    String message() default "{com.hotfixs.frameworks.hibernatevalidator.customconstraints.crossparameter"
            + ".ScriptAssert.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String script();

    ConstraintTarget validationAppliesTo() default ConstraintTarget.IMPLICIT;
}
