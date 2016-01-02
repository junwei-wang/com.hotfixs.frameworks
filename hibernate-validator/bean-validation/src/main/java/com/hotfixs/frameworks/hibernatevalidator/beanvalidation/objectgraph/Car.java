package com.hotfixs.frameworks.hibernatevalidator.beanvalidation.objectgraph;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author wangjunwei
 */
public class Car {

    @NotNull
    @Valid
    private Person driver;

    @NotNull
    @Valid
    private List<Person> customes;
}
