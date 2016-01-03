package com.hotfixs.frameworks.messageinterpolation.resourcebundlelocator;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

/**
 * @author wangjunwei
 */
public class Car {

    @NotNull
    private String licensePlate;

    @Max(300)
    private int topSpeed = 400;

}
