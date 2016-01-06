package com.hotfixs.frameworks.hibernatevalidator.constrainsgroup;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */

import javax.validation.GroupSequence;
import javax.validation.constraints.AssertFalse;

/**
 * Since there must no cyclic dependency in the group and group sequence definitions
 * one cannot just add Default to the sequence redefining Default for a class.
 * Instead the class itself has to be added!
 */
@GroupSequence({RentalChecks.class, CarChecks.class, RentalCar.class})
public class RentalCar extends Car {
    @AssertFalse(message = "The car is currently rented out", groups = RentalChecks.class)
    private boolean rented;

    public RentalCar(String manufacturer, String licencePlate, int seatCount) {
        super(manufacturer, licencePlate, seatCount);
    }

    public boolean isRented() {
        return rented;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }
}
