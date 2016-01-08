package com.hotfixs.frameworks.hibernatevalidator.customconstraints.crossparameter;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */
@Target({ METHOD, CONSTRUCTOR, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {ConsistentDateParametersValidator.class})
public @interface ConsistentDateParameters {
    String message() default "{com.hotfixs.frameworks.hibernatevalidator.customconstraints.crossparameter"
            + ".ConsistentDateParameters.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
