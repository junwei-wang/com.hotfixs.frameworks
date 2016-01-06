package com.hotfixs.frameworks.hibernatevalidator.constrainsgroup;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */

import javax.validation.constraints.NotNull;

public class Person {

    @NotNull
    private String name;

    public Person(String name) {
        this.name = name;
    }

    // getters and setters ...
}
