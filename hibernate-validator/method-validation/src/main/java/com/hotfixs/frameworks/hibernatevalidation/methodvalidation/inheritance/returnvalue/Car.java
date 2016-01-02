package com.hotfixs.frameworks.hibernatevalidation.methodvalidation.inheritance.returnvalue;

import java.util.List;

import javax.validation.constraints.Size;

/**
 * @author wangjunwei
 */
public class Car implements Vehicle {

    @Override
    @Size(min = 1)
    public List<Person> getPassengers() {
        //...
        return null;
    }
}
