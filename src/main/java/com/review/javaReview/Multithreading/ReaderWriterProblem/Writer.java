package com.review.javaReview.Multithreading.ReaderWriterProblem;

import java.util.Date;

public class Writer extends Thread {
    public void run() {
        while(true) {
            synchronized (RW.LW) {
                boolean done = false;
                while (!done) {
                    synchronized (RW.LR) {
                        if (RW.readCount == 0) {
                            RW.data = new Date();
                            done = true;
                        } else {
                            try {
                                while(RW.readCount !=0) {
                                    RW.LR.wait();
                                }
                            } catch (InterruptedException e) {
                                System.out.println("Interrupted Exception");
                            }
                        }
                    }
                }
                System.out.println("done writing doing something else");
            }
        }
    }
}
