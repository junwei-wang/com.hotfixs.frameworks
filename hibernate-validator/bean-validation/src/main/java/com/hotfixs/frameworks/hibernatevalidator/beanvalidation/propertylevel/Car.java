package com.hotfixs.frameworks.hibernatevalidator.beanvalidation.propertylevel;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;

/**
 * @author wangjunwei
 */
public class Car {
    private String manufacturer;

    private boolean isRegistred;

    public Car(String manufacturer, boolean isRegistred) {
        this.manufacturer = manufacturer;
        this.isRegistred = isRegistred;
    }

    @NotNull
    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @AssertTrue
    public boolean isRegistred() {
        return isRegistred;
    }

    public void setRegistred(boolean isRegistred) {
        this.isRegistred = isRegistred;
    }
}

