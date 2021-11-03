package com.review.MultiThreading.BlockingQueue;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
    protected BlockingQueue<Object> queue;

    Consumer(BlockingQueue<Object> theQueue) {
        this.queue = theQueue;
    }

    @Override
    public void run() {
        try {
            while(true) {
                Object obj = queue.take();
                System.out.println("Consumer resource - Queue size now =" + queue.size());
                take(obj);
            }
        } catch (InterruptedException ex) {
            System.out.println("Consumer Interrupted");
        }
    }

    void take(Object obj) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            System.out.println("Consumer Read Interrupted");
        }
        System.out.println("Consumer object" + obj);
    }
}
