package com.hotfixs.frameworks.hibernatevalidator.constrainsgroup.groupsequenceprovider;

import com.hotfixs.frameworks.hibernatevalidator.constrainsgroup.Car;
import com.hotfixs.frameworks.hibernatevalidator.constrainsgroup.RentalChecks;

import org.hibernate.validator.group.GroupSequenceProvider;

import javax.validation.constraints.AssertFalse;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */
@GroupSequenceProvider(RentalCarGroupSequenceProvider.class)
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

