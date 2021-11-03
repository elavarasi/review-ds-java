package com.review.MultiThreading.RateLimiting;

import java.util.HashSet;
import java.util.Set;

public class TokenBucketFilter {
    private int MAX_TOKEN;
    private long lastRequestTime = System.currentTimeMillis();
    long possibleToken = 0;

    public TokenBucketFilter(int maxTokens) {
        MAX_TOKEN = maxTokens;
    }

    synchronized void getToken() throws InterruptedException {
        possibleToken += (System.currentTimeMillis() - lastRequestTime) / 1000;

        if (possibleToken > MAX_TOKEN) {
            possibleToken = MAX_TOKEN;
        }

        if (possibleToken == 0) {
            Thread.sleep(1000);
        } else {
            possibleToken--;
        }

        lastRequestTime = System.currentTimeMillis();

        System.out.println("Granting" + Thread.currentThread().getName() + " token at" +  (System.currentTimeMillis()));

    }

    public static void runTestMaxToken1() throws InterruptedException {
        Set<Thread> allThreads = new HashSet<Thread>();

        final TokenBucketFilter tokenBucketFilter = new TokenBucketFilter(5);

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        tokenBucketFilter.getToken();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

            thread.setName("Thread_" + (i + 1));
            allThreads.add(thread);
        }

        for (Thread t : allThreads) {
            t.start();
        }

        for (Thread t : allThreads) {
            t.join();
        }
    }

}

class Demonstrate {
    public static void main (String args[]) throws InterruptedException {
        TokenBucketFilter.runTestMaxToken1();
    }
}
