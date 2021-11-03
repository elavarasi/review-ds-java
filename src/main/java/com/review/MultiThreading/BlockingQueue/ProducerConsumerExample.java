package com.review.MultiThreading.BlockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class ProducerConsumerExample {
    public static void main(String args[]) throws InterruptedException {
        int numProducers = 4;
        int numConsumers = 3;

        BlockingQueue<Object> myQueue = new LinkedBlockingDeque<>(20);

        for (int i = 0; i < numProducers; i++) {
            new Thread(new Producer(myQueue)).start();
        }

        for (int j = 0; j < numConsumers; j++) {
            new Thread(new Consumer(myQueue)).start();
        }

        Thread.sleep(10 * 1000);

        System.exit(0);

    }
}
