package com.review.DesignPatterns.Observer;

public interface Observer {
    void update();

    void subscribeChannel(Channel ch);
}
