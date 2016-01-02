package com.hotfixs.frameworks.hibernatevalidation.methodvalidation.inheritance.returnvalue;

import java.util.List;

import javax.validation.constraints.NotNull;

/**
 * @author wangjunwei
 */
public interface Vehicle {

    @NotNull
    List<Person> getPassengers();
}
