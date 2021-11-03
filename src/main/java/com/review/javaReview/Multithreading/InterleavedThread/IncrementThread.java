package com.review.javaReview.Multithreading.InterleavedThread;

public class IncrementThread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < TwoThreadIncrementDriver.N; i++) {
            TwoThreadIncrementDriver.counter ++;
        }
    }
}

