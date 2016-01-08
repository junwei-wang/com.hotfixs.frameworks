package com.hotfixs.frameworks.hibernatevalidator.customconstraints.crossparameter;

import java.util.List;

import javax.validation.ConstraintTarget;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */
public class ScriptAssertExample {

    @ScriptAssert(script = "arg1.size() <= arg0", validationAppliesTo = ConstraintTarget.PARAMETERS)
    public Car buildCar(int seatCount, List<Passenger> passengers) {
        //...
        return null;
    }

    private static class Car {
    }

    private static class Passenger {
    }
}
