package com.hotfixs.frameworks.hibernatevalidation.methodvalidation.inheritance.parameter;

/**
 * @author wangjunwei
 */

import javax.validation.constraints.Max;

public class Car implements Vehicle {

    // Illegal
    @Override
    public void drive(@Max(55) int speedInMph) {
        //...
    }
}
