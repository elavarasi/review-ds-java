package com.review.javaReview.Multithreading.EducativeIO;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Demonstration {
    public static void main(String args[]) throws InterruptedException {
//        SumUpExample.runTest();

//        InterruptExample ie = new InterruptExample();
//        ie.example();

        MissedSignalExample.example();
    }
}

class SumUpExample {
    long startRange;
    long endRange;
    long counter = 0;
    static long MAX_NUM = Integer.MAX_VALUE;

    public SumUpExample(long startRange, long endRange) {
        this.startRange = startRange;
        this.endRange = endRange;
    }

    public void add() {
        for (long i = startRange; i <= endRange; i++) {
            counter += i;
        }
    }

    static public void twoThreads() throws InterruptedException {
        long start = System.currentTimeMillis();
        SumUpExample s1 = new SumUpExample(1, MAX_NUM / 2);
        SumUpExample s2 = new SumUpExample(1 + (MAX_NUM / 2), MAX_NUM);

        Thread t1 = new Thread(() -> {
            s1.add();
        });

        Thread t2 = new Thread(() -> {
            s2.add();
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        long finalCount = s1.counter + s1.counter;
        long end = System.currentTimeMillis();
        System.out.println("Two threads final count " + finalCount + "took" + (end - start));
    }

    public static void oneThread() {
        long start = System.currentTimeMillis();
        SumUpExample s = new SumUpExample(1, MAX_NUM );
        s.add();
        long end = System.currentTimeMillis();
        System.out.println("Single thread final count = " + s.counter + " took " + (end - start));
    }


    public static void runTest() throws InterruptedException {
        oneThread();
        twoThreads();
    }
}

class InterruptExample {
    static public void example() throws InterruptedException {
        Thread sleepyThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("Going to sleep for a very long time");
                    Thread.sleep(1000 * 60 * 60);
                } catch (InterruptedException e){
                    System.out.println("The interrupt flag is interrupted" + Thread.interrupted() + " " + Thread.currentThread().isInterrupted());
                    Thread.currentThread().interrupt();
                    System.out.println("Oh some one woke me up");
                    System.out.println("The interrupt flag is set now " + Thread.currentThread().isInterrupted() + " " + Thread.interrupted());
                }
            }
        });

        sleepyThread.start();
        System.out.println("About to wake up sleepy thread");
        sleepyThread.interrupt();
        System.out.println("Woke up sleepy Thread");
        sleepyThread.join();
    }
}


class MissedSignalExample {
    public static void example() throws InterruptedException {
        final ReentrantLock lock = new ReentrantLock();
        final Condition condition = lock.newCondition();

        Thread signaller = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                condition.signal();
                System.out.println("Sent signal");

                lock.unlock();
            }
        });

        Thread waiter = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    condition.await();
                    System.out.println("Received signal");
                } catch (InterruptedException e) {

                    e.printStackTrace();
                }

                lock.unlock();

            }
        });

        signaller.start();
        signaller.join();

        waiter.start();
        waiter.join();

        System.out.println("Program Excited");
    }
}