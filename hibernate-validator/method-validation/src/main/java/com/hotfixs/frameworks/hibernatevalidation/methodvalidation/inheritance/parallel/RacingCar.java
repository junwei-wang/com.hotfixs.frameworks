package com.hotfixs.frameworks.hibernatevalidation.methodvalidation.inheritance.parallel;

/**
 * @author wangjunwei
 */
public class RacingCar implements Car, Vehicle {

    @Override
    public void drive(int speedInMph) {
        //...
    }
}
