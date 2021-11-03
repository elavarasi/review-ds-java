package com.review.DesignPatterns.ChainOfResponsibility;

public class Client {
    public static void main(String[] args) {
        AbstractHandler lowFuelHandler = new LowFuelHandler(null);
        FireHandler fireHandler = new FireHandler(lowFuelHandler);

        LowFuelRequest lowFuelRequest = new LowFuelRequest();

        fireHandler.handleRequest(lowFuelRequest);
    }
}
