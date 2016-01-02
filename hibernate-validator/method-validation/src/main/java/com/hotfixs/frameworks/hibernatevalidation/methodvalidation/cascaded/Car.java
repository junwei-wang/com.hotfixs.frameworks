package com.hotfixs.frameworks.hibernatevalidation.methodvalidation.cascaded;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author wangjunwei
 */
public class Car {

    @NotNull
    private String manufacturer;

    @NotNull
    @Size(min = 2, max = 14)
    private String licensePlate;

    public Car(String manufacturer, String licencePlate) {
        this.manufacturer = manufacturer;
        this.licensePlate = licencePlate;
    }

    //getters and setters ...
}
