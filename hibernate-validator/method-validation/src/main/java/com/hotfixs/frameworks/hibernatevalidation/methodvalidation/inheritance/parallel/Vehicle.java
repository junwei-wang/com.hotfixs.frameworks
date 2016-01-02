package com.hotfixs.frameworks.hibernatevalidation.methodvalidation.inheritance.parallel;

/**
 * @author wangjunwei
 */

import javax.validation.constraints.Max;

public interface Vehicle {
    void drive(@Max(75) int speedInMph);
}
