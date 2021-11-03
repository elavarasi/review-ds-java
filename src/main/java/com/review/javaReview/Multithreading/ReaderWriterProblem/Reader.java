package com.review.javaReview.Multithreading.ReaderWriterProblem;

public class Reader extends Thread {
    public void run() {
        System.out.println(RW.LR);
        System.out.println(RW.data);
        while(true) {
            synchronized (RW.LR) {
                RW.readCount++;
            }
            System.out.println(RW.LR);
            synchronized (RW.LR) {
                RW.readCount --;
                RW.LR.notify();
            }
            System.out.println("done reading doing something else");
        }
    }
}
