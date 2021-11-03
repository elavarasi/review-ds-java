package com.review.DesignPatterns.Singleton;

public class AirforceOne {
    private static AirforceOne airForceOne;

    private AirforceOne() {

    }

    public synchronized static AirforceOne getInstance() {
        if (airForceOne == null) {
            synchronized (AirforceOne.class) {
                if (airForceOne == null) {
                    airForceOne = new AirforceOne();
                }
            }

        }

        return airForceOne;
    }

}


