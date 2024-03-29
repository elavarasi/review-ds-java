package com.review.DesignPatterns.BuilderDesignPattern;

public class PhoneBuilder {
    private String OS;
    private int ram;
    private String processor;
    private int battery;

    public PhoneBuilder setOS(String OS) {
        this.OS = OS;
        return this;
    }

    public PhoneBuilder setRam(int ram) {
        this.ram = ram;
        return this;
    }

    public PhoneBuilder setProcessor(String processor) {
        this.processor = processor;
        return this;
    }

    public PhoneBuilder setBattery(int battery) {
        this.battery = battery;
        return this;
    }

    public Phone getPhone() {
        return new Phone(OS, ram, processor, battery);
    }

}
