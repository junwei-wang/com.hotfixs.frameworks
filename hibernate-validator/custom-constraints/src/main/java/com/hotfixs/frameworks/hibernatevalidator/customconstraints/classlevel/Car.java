package com.hotfixs.frameworks.hibernatevalidator.customconstraints.classlevel;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */

import java.util.List;

@ValidPassengerCount(message = "There must be not more passengers than seats.")
public class Car {

    private int seatCount;

    private List<Person> passengers;

    public Car(int seatCount, List<Person> passengers) {
        this.seatCount = seatCount;
        this.passengers = passengers;
    }

    public int getSeatCount() {
        return seatCount;
    }

    public List<Person> getPassengers() {
        return passengers;
    }
}
