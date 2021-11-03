package com.review.DesignPatterns.Singleton;

public class LazyInitializationHolder {
    private LazyInitializationHolder() {

    }

    private static class RegistryHolder {
        static LazyInitializationHolder INSTANCE = new LazyInitializationHolder();
    }

    public static LazyInitializationHolder getInstance() {
        return RegistryHolder.INSTANCE;
    }

}
