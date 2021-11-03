package com.review.ObjectOrientedDesignInterview;

public class ParkingLot {
}


enum VehicleType {
    CAR, TRUCK, ELECTRIC, VAN, MOTORBIKE
}

enum ParkingSpotType {
    HANDICAPPED, COMPACT, LARGE, MOTORBIKE, ELECTRIC
}

enum AccountStatus {
    ACTIVE, BLOCKED, BANNED, COMPROMISED, ARCHIVED, UNKNOWN
}

class Address {
    private String streetAddress;
    private String city;
}

class Person {
    private String name;
    private Address address;
    private String email;
    private String phone;
}






