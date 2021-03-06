package com.hotfixs.frameworks.hibernatevalidator.beanvalidation.typeargument;

/**
 * @author wangjunwei
 */
public class Gear {
    private final Integer torque;

    public Gear(Integer torque) {
        this.torque = torque;
    }

    public Integer getTorque() {
        return torque;
    }

    public static class AcmeGear extends Gear {
        public AcmeGear() {
            super(100);
        }
    }
}
