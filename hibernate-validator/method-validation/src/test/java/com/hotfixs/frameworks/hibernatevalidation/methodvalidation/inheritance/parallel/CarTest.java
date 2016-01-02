package com.hotfixs.frameworks.hibernatevalidation.methodvalidation.inheritance.parallel;

import org.junit.BeforeClass;
import org.junit.Test;

import java.lang.reflect.Method;

import javax.validation.ConstraintDeclarationException;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import javax.validation.executable.ExecutableValidator;

/**
 * @author wangjunwei
 */
public class CarTest {
    private static ExecutableValidator executableValidator;

    @BeforeClass
    public static void setUpValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        executableValidator = factory.getValidator().forExecutables();
    }

    @Test(expected = ConstraintDeclarationException.class)
    public void illegalParameterConstraintsInParallelTypes() throws Exception {
        RacingCar object = new RacingCar();
        Method method = Car.class.getMethod("drive", int.class);
        Object[] parameterValues = {};
        executableValidator.validateParameters(
                object,
                method,
                parameterValues
        );
    }
}