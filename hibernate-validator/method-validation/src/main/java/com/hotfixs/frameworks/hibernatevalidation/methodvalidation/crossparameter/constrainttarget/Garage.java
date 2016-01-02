package com.hotfixs.frameworks.hibernatevalidation.methodvalidation.crossparameter.constrainttarget;

/**
 * @author wangjunwei
 */

import java.util.List;

import javax.validation.ConstraintTarget;

public class Garage {

    @ELAssert(expression = "...", validationAppliesTo = ConstraintTarget.PARAMETERS)
    public Car buildCar(List<Part> parts) {
        return null;
    }

    @ELAssert(expression = "...", validationAppliesTo = ConstraintTarget.RETURN_VALUE)
    public Car paintCar(int color) {
        return null;
    }
}
