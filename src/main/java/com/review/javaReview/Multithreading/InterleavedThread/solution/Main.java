package com.review.javaReview.Multithreading.InterleavedThread.solution;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        OddEvenMonitor monitor = new OddEvenMonitor();
        Thread t1 = new OddThread(monitor);
        Thread t2 = new OddThread(monitor);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

    }
}
