package com.hotfixs.frameworks.hibernatevalidator.customconstraints.constraintscomposition.reportassingle;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import com.hotfixs.frameworks.hibernatevalidator.customconstraints.CaseMode;
import com.hotfixs.frameworks.hibernatevalidator.customconstraints.CheckCase;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */
@NotNull
@Size(min = 2, max = 14)
@CheckCase(CaseMode.UPPER)
@Target({ METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = {})
@ReportAsSingleViolation
@Documented
public @interface ValidLicensePlate {
    String message() default "{com.hotfixs.frameworks.hibernatevalidator.customconstraints.constraintscomposition"
            + ".reportassingle.ValidLicensePlate.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
