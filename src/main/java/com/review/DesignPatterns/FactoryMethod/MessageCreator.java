package com.review.DesignPatterns.FactoryMethod;

public abstract class MessageCreator {
    public Message getMessage() {
        Message msg = createMessage();
        msg.addDefaultHeaders();
        msg.encrypt();
        return msg;
    }

    protected abstract Message createMessage();
}
