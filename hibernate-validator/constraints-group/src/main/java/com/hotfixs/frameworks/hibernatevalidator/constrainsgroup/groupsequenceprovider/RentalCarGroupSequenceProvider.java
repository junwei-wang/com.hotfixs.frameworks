package com.hotfixs.frameworks.hibernatevalidator.constrainsgroup.groupsequenceprovider;

import com.hotfixs.frameworks.hibernatevalidator.constrainsgroup.CarChecks;
import com.hotfixs.frameworks.hibernatevalidator.constrainsgroup.RentalCar;

import org.hibernate.validator.spi.group.DefaultGroupSequenceProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */
public class RentalCarGroupSequenceProvider implements DefaultGroupSequenceProvider<RentalCar> {
    @Override
    public List<Class<?>> getValidationGroups(RentalCar rentalCar) {
        List<Class<?>> defaultGroupSequence = new ArrayList<>();
        defaultGroupSequence.add(RentalCar.class);

        if (rentalCar != null && !rentalCar.isRented()) {
            defaultGroupSequence.add(CarChecks.class);
        }

        return defaultGroupSequence;
    }
}
