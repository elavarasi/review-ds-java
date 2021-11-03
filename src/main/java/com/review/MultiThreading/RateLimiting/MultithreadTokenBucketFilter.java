package com.review.MultiThreading.RateLimiting;

import java.util.HashSet;
import java.util.Set;

public class MultithreadTokenBucketFilter {
    private long possibleToken = 0;
    private final int MAX_TOKENS;
    private final int ONE_SECOND = 1000;

    public MultithreadTokenBucketFilter(int maxToken) {
        this.MAX_TOKENS = maxToken;

        Thread dt = new Thread(() -> {
            daemonThread();
        });
        dt.setDaemon(true);
        dt.start();
    }

    private void daemonThread() {
        while (true) {
            synchronized (this) {
                if (possibleToken < MAX_TOKENS) {
                    possibleToken ++;
                }
                this.notify();
            }

            try {
                Thread.sleep(ONE_SECOND);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    void getToken() throws InterruptedException {
        synchronized (this) {
            while(possibleToken == 0) {
                this.wait();
            }
            possibleToken--;
        }

        System.out.println("Granting" +
                Thread.currentThread().getName() + "tokean at" + System.currentTimeMillis() / 1000);
    }
}


class Demonstration {
    public static void main(String args[]) throws InterruptedException {
        Set<Thread> allThread = new HashSet<Thread>();

        final MultithreadTokenBucketFilter tokenBucketFilter = new MultithreadTokenBucketFilter(1);

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        tokenBucketFilter.getToken();
                    } catch (InterruptedException e) {
                        System.out.println("We have a problem");
                    }
                }
            });
            thread.setName("Thread_" + (i + 1));
            allThread.add(thread);
        }

        for (Thread t : allThread) {
            t.start();
        }

        for (Thread t : allThread) {
            t.join();
        }



    }
}
