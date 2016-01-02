package com.hotfixs.frameworks.hibernatevalidation.methodvalidation.validation;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Path;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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

    @Test
    public void validateParameters() throws Exception {
        Car object = new Car("Morris");
        Method method = Car.class.getMethod("drive", int.class);
        Object[] parameterValues = {80};
        Set<ConstraintViolation<Car>> violations = executableValidator.validateParameters(
                object,
                method,
                parameterValues
        );

        assertEquals(1, violations.size());
        Class<? extends Annotation> constraintType = violations.iterator()
                .next()
                .getConstraintDescriptor()
                .getAnnotation()
                .annotationType();
        assertEquals(Max.class, constraintType);
    }

    @Test
    public void validateReturnValue() throws Exception {
        Car object = new Car("Morris");
        Method method = Car.class.getMethod("getPassengers");
        Object returnValue = Collections.<Passenger>emptyList();
        Set<ConstraintViolation<Car>> violations = executableValidator.validateReturnValue(
                object,
                method,
                returnValue
        );

        assertEquals(1, violations.size());
        Class<? extends Annotation> constraintType = violations.iterator()
                .next()
                .getConstraintDescriptor()
                .getAnnotation()
                .annotationType();
        assertEquals(Size.class, constraintType);
    }

    @Test
    public void validateConstructorParameters() throws Exception {
        Constructor<Car> constructor = Car.class.getConstructor(String.class);
        Object[] parameterValues = {null};
        Set<ConstraintViolation<Car>> violations = executableValidator.validateConstructorParameters(
                constructor,
                parameterValues
        );

        assertEquals(1, violations.size());
        Class<? extends Annotation> constraintType = violations.iterator()
                .next()
                .getConstraintDescriptor()
                .getAnnotation()
                .annotationType();
        assertEquals(NotNull.class, constraintType);
    }

    @Test
    public void validateConstructorReturnValue() throws Exception {
        //constructor for creating racing cars
        Constructor<Car> constructor = Car.class.getConstructor(String.class, String.class);
        Car createdObject = new Car("Morris", null);
        Set<ConstraintViolation<Car>> violations = executableValidator.validateConstructorReturnValue(
                constructor,
                createdObject
        );

        assertEquals(1, violations.size());
        Class<? extends Annotation> constraintType = violations.iterator()
                .next()
                .getConstraintDescriptor()
                .getAnnotation()
                .annotationType();
        assertEquals(ValidRacingCar.class, constraintType);
    }

    @Test
    public void retrieveMethodAndParameterInformation() throws Exception {
        Car object = new Car("Morris");
        Method method = Car.class.getMethod("drive", int.class);
        Object[] parameterValues = {80};
        Set<ConstraintViolation<Car>> violations = executableValidator.validateParameters(
                object,
                method,
                parameterValues
        );

        assertEquals(1, violations.size());
        Iterator<Path.Node> propertyPath = violations.iterator()
                .next()
                .getPropertyPath()
                .iterator();

        Path.MethodNode methodNode = propertyPath.next().as(Path.MethodNode.class);
        assertEquals("drive", methodNode.getName());
        assertEquals(Arrays.<Class<?>>asList(int.class), methodNode.getParameterTypes());

        Path.ParameterNode parameterNode = propertyPath.next().as(Path.ParameterNode.class);
        assertEquals("arg0", parameterNode.getName());
        assertEquals(0, parameterNode.getParameterIndex());
    }
}
