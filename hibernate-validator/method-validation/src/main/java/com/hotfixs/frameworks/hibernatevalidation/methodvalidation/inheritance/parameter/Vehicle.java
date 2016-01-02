package com.hotfixs.frameworks.hibernatevalidation.methodvalidation.inheritance.parameter;

/**
 * @author wangjunwei
 */

import javax.validation.constraints.Max;

public interface Vehicle {

    void drive(@Max(75) int speedInMph);
}
