package com.hotfixs.frameworks.hibernatevalidator.beanvalidation.inheritance;

import javax.validation.constraints.NotNull;

/**
 * @author wangjunwei
 */
public class RentalCar extends Car {

    private String rentalStation;

    @NotNull
    public String getRentalStation() {
        return rentalStation;
    }
}
