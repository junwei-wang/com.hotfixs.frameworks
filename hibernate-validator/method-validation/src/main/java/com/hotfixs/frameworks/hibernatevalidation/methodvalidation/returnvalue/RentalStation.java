package com.hotfixs.frameworks.hibernatevalidation.methodvalidation.returnvalue;


import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author wangjunwei
 */
public class RentalStation {

    @ValidRentalStation
    public RentalStation() {
    }

    @NotNull
    @Size(min = 1)
    public List<Customer> getCustomers() {
        return null;
    }
}
