package com.review.DesignPatterns.FactoryMethod;

public class JSONMessageCreator extends MessageCreator {

    @Override
    protected Message createMessage() {
        return new JSONMessage();
    }
}
