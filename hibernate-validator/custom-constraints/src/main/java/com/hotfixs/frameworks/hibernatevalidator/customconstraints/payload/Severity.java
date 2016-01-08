package com.hotfixs.frameworks.hibernatevalidator.customconstraints.payload;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */

import javax.validation.Payload;

public class Severity {
    public interface Info extends Payload {
    }

    public interface Error extends Payload {
    }
}
