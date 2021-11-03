package com.review.javaReview.Multithreading.EducativeIO;

public class Demonstration1 {

    public static void main(String args[]) throws InterruptedException {

        //Anonymous class in Thread constructor
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("ela1");
            }
        });

        t1.start();


        // Way 2 -> Separate class implementing runnable
        ExecuteMe e1 = new ExecuteMe();
        Thread t2 = new Thread(e1);
        t2.start();


        ExecuteMe1 e2 = new ExecuteMe1();
        e2.start();
        e2.join();
    }
}

class ExecuteMe implements Runnable {
     public void run() {
        System.out.println("ela2");
     }
}

class ExecuteMe1 extends Thread {
    public void run() {
        System.out.println("ela3");
    }
}

