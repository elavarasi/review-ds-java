//package com.review.ObjectOrientedDesignInterview;
//
//public class MovieBookingSystem {
//
//
//}
//
//
//enum BookingStatus {
//    REQUESTED, PENDING, CONFIRMED, CHECKED_IN, CANCELED
//}
//
//enum SeatType {
//    REGULAR, PREMIUM, ACCESSIBLE, SHIPPED, OTHER
//}
//
//enum PaymentStatus {
//    UNPAID, PENDING, COMPLETED, FILLED, DECLINED, CANCELLED
//}
//
//class Address1 {
//    private String streetAddress;
//    private String city;
//    private String zipCode;
//    private String country;
//}
//
//
//class Account {
//    private String id;
//    private String password;
//    private AccountStatus status;
//
//    public boolean resetPassword() {
//        return false;
//    }
//}
//
//abstract class Person {
//    private String name;
//    private Address address;
//    private String email;
//    private String phone;
//}
//
//class Customer extends Person {
//    public boolean makeBooking(Booking booking);
//    public List<Booking> getBookings();
//}
//
//
//
