package com.review.javaReview.Multithreading.InterleavedThread.solution;

public class OddEvenMonitor {
    public static final boolean ODD_TURN = true;
    public static final boolean EVEN_TURN = false;
    private boolean turn = ODD_TURN;


    public synchronized void waitTurn(boolean oldTurn) {
        while (turn != oldTurn) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void toggleTurn() {
        turn ^= true;
        notify();
    }
}
