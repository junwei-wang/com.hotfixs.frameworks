package com.hotfixs.frameworks.hibernatevalidator.beanvalidation.fieldleve;

import com.sun.istack.internal.NotNull;

import javax.validation.constraints.AssertTrue;

/**
 * @author wangjunwei
 */
public class Car {
    @NotNull
    private String manufacturer;

    @AssertTrue
    private boolean isRegistred;

    public Car(String manufacturer, boolean isRegistred) {
        this.manufacturer = manufacturer;
        this.isRegistred = isRegistred;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public boolean isRegistred() {
        return isRegistred;
    }

    public void setRegistred(boolean isRegistred) {
        this.isRegistred = isRegistred;
    }
}

