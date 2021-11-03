package com.review.javaReview.Multithreading.InterleavedThread;

import com.review.javaReview.Multithreading.InterleavedThread.IncrementThread;

public class TwoThreadIncrementDriver {

    public static int counter;
    public static int N;

    public static void main(String args[]) throws InterruptedException {
        N = (args.length > 0) ? new Integer(args[0]) : 1000000;

        Thread t1 = new Thread(new IncrementThread());
        Thread t2 = new Thread(new IncrementThread());

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(counter);

    }

}
