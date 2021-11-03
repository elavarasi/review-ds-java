package com.review.MultiThreading.BlockingQueue;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
    Producer(BlockingQueue<Object> bqueue) {
        this.queue = bqueue;
    }

    protected BlockingQueue<Object> queue;

    public void run() {
        try {
            while(true) {
                Object justProduced = getResource();
                queue.put(justProduced);
                System.out.println("Producer has produced a resource" + queue.size());

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    Object getResource() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            System.out.println("Producer Read INTERRUPTED");
        }

        return new Object();
    }
}
