package com.hotfixs.frameworks.hibernatevalidator.beanvalidation.inheritance;

import javax.validation.constraints.NotNull;

/**
 * @author wangjunwei
 */
public class Car {

    private String manufacturer;

    @NotNull
    public String getManufacturer() {
        return manufacturer;
    }
}
