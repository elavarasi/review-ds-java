package com.review.DesignPatterns.BuilderDesignPattern;

public class Phone {
    private String OS;
    private int ram;
    private String processor;
    private int battery;

    public Phone(String os, int ram, String processor, int battery) {
        super();
        this.OS = os;
        this.ram = ram;
        this.processor = processor;
        this.battery = battery;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "OS='" + OS + '\'' +
                ", ram=" + ram +
                ", processor='" + processor + '\'' +
                ", battery=" + battery +
                '}';
    }
}
