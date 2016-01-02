package com.hotfixs.frameworks.hibernatevalidation.methodvalidation.crossparameter;

import java.util.List;

/**
 * @author wangjunwei
 */
public class Car {

    @LuggageCountMatchesPassengerCount(piecesOfLuggagePerPassenger = 2)
    public void load(List<Person> passengers, List<PieceOfLuggage> luggage) {
    }
}
