package com.hotfixs.frameworks.hibernatevalidator.beanvalidation.classlevel;

import java.util.List;

/**
 * @author wangjunwei
 */
@ValidPassengerCount
public class Car {
    private int seatCount;

    private List<Person> passengers;
}
