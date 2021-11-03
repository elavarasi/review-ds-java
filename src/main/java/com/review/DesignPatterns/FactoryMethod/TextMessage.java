package com.review.DesignPatterns.FactoryMethod;

public class TextMessage extends Message {

    @Override
    public String getContent() {
        return "Text";
    }
}
