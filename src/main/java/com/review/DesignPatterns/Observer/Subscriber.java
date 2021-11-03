package com.review.DesignPatterns.Observer;

public class Subscriber implements Observer {
    private String name;
    private Channel channel = new Channel();

    public Subscriber(String ela) {
        super();
        this.name = name;
    }

    @Override
    public void update() {
        System.out.println("Video uploaded");
    }

    @Override
    public void subscribeChannel(Channel ch) {
        channel = ch;
    }

}
