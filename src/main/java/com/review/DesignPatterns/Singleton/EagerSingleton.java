package com.review.DesignPatterns.Singleton;

public class EagerSingleton {

    private EagerSingleton() {

    }

    private static final EagerSingleton instance = new EagerSingleton();

    public static EagerSingleton getEagerSingletonInstance() {
        return instance;
    }

}
