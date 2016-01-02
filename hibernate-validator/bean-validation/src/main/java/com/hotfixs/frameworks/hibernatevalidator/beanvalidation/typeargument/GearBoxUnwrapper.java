package com.hotfixs.frameworks.hibernatevalidator.beanvalidation.typeargument;

import org.hibernate.validator.spi.valuehandling.ValidatedValueUnwrapper;

import java.lang.reflect.Type;

/**
 * @author wangjunwei
 */
public class GearBoxUnwrapper extends ValidatedValueUnwrapper<GearBox> {
    @Override
    public Object handleValidatedValue(GearBox gearBox) {
        return gearBox == null ? null : gearBox.getGear();
    }

    @Override
    public Type getValidatedValueType(Type valueType) {
        return Gear.class;
    }
}
