package com.hotfixs.frameworks.hibernatevalidator.beanvalidation.typeargument;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

/**
 * @author wangjunwei
 */
public class Car {
    public enum FuelConsumption {
        CITY,
        HIGHWAY
    }

    @Valid
    private List<@ValidPart String> parts = new ArrayList<>();

    @Valid
    private EnumMap<FuelConsumption, @MaxAllowedFuelConsumption Integer> fuelConsumption =
            new EnumMap<>(FuelConsumption.class);

    private Optional<@MinTowingCapacity(1000) Integer> towingCapacity = Optional.empty();

    private GearBox<@MinTorque(100) Gear> gearBox;

    public void addPart(String part) {
        parts.add(part);
    }

    public void setTowingCapacity(Integer alias) {
        towingCapacity = Optional.of(alias);
    }

    public void setFuelConsumption(FuelConsumption consumption, int value) {
        fuelConsumption.put(consumption, value);
    }

    public void setGearBox(GearBox<Gear> gearBox) {
        this.gearBox = gearBox;
    }
}
