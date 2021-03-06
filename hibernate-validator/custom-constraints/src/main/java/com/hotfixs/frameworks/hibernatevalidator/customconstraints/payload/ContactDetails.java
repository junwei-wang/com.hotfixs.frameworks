package com.hotfixs.frameworks.hibernatevalidator.customconstraints.payload;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */

import javax.validation.constraints.NotNull;

public class ContactDetails {
    @NotNull(message = "Name is mandatory", payload = Severity.Error.class)
    private String name;

    @NotNull(message = "Phone number not specified, but not mandatory",
            payload = Severity.Info.class)
    private String phoneNumber;

}
