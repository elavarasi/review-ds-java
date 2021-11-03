package com.review.DesignPatterns.FactoryMethod;

public class Client {
    public static void main(String args[]) {
        printMessage(new JSONMessageCreator());
        printMessage(new TEXTMessageCreator());
    }

    public static void printMessage(MessageCreator creator) {
        Message msg = creator.getMessage();
        System.out.println(msg.getContent());
    }
}
