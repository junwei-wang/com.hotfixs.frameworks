package com.hotfixs.frameworks.hibernatevalidator.constrainsgroup;

import javax.validation.GroupSequence;
import javax.validation.groups.Default;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */
@GroupSequence({Default.class, CarChecks.class, DriverChecks.class})
public interface OrderedChecks {
}
