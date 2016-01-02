package com.hotfixs.frameworks.hibernatevalidation.methodvalidation.cascaded;

/**
 * @author wangjunwei
 */

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class Garage {

    @NotNull
    private String name;

    @Valid
    public Garage(String name) {
        this.name = name;
    }

    public boolean checkCar(@Valid @NotNull Car car) {
        //...
        return false;
    }

    public boolean checkCars(@Valid @NotNull List<Car> cars) {
        //...
        return false;
    }
}
