package com.review.DesignPatterns.FactoryMethod;

public class TEXTMessageCreator extends MessageCreator {
    @Override
    protected Message createMessage() {
        return new TextMessage();
    }
}
