package com.review.javaReview.Multithreading;

public class program1 {
    public static void main(String args[]) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("We are in thread****" + Thread.currentThread().getName());
            }
        });



        thread.setName("New Thread");

        System.out.println("We are in thread" + Thread.currentThread().getName());
        thread.start();
        System.out.println("We are in thread" + Thread.currentThread().getName());

        Thread.sleep(10000);

    }
}
