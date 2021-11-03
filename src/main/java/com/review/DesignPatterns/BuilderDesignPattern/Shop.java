package com.review.DesignPatterns.BuilderDesignPattern;

public class Shop {
    public static void main(String args[]) {
        Phone p = new PhoneBuilder().setBattery(232).setOS("OS").getPhone();
        System.out.println(p);
    }
}
