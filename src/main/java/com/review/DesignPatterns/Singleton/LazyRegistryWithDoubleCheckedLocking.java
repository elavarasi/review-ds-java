package com.review.DesignPatterns.Singleton;

public class LazyRegistryWithDoubleCheckedLocking {
    private LazyRegistryWithDoubleCheckedLocking() {

    }

    private static volatile LazyRegistryWithDoubleCheckedLocking INSTANCE;

    public static LazyRegistryWithDoubleCheckedLocking getInstance() {
        if (INSTANCE == null) {
            synchronized (LazyRegistryWithDoubleCheckedLocking.class) {

                if (INSTANCE == null) {
                    INSTANCE = new LazyRegistryWithDoubleCheckedLocking();
                }
            }
        }
        return INSTANCE;
    }

}
