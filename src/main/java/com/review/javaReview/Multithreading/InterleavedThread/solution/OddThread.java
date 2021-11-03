package com.review.javaReview.Multithreading.InterleavedThread.solution;

public class OddThread extends Thread {
    private OddEvenMonitor monitor;

    public OddThread(OddEvenMonitor monitor) {
        this.monitor = monitor;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i +=2) {
            monitor.waitTurn(OddEvenMonitor.ODD_TURN);
            monitor.toggleTurn();
        }
    }
}
