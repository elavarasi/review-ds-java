package com.review.DesignPatterns.Singleton;

public class Client {

    public static void main(String args[]) {
        EagerSingleton obj1 = EagerSingleton.getEagerSingletonInstance();
        EagerSingleton obj2 = EagerSingleton.getEagerSingletonInstance();

        System.out.println(obj1 == obj2);

        LazyRegistryWithDoubleCheckedLocking obj3 = LazyRegistryWithDoubleCheckedLocking.getInstance();
        LazyRegistryWithDoubleCheckedLocking obj4 = LazyRegistryWithDoubleCheckedLocking.getInstance();
        System.out.println(obj3 == obj4);

        LazyInitializationHolder singleton;
        singleton = LazyInitializationHolder.getInstance();
        singleton = LazyInitializationHolder.getInstance();

        AirforceOne.getInstance();



    }

}
