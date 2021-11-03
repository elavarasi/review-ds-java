package com.review.javaReview.Multithreading.InterleavedThread.solution;

public class EvenThread extends Thread {
    private final OddEvenMonitor monitor;

    public EvenThread(OddEvenMonitor monitor) {
        this.monitor = monitor;
    }

    @Override
    public void run() {
        for (int i = 2; i <= 100; i +=2) {
            monitor.waitTurn(OddEvenMonitor.EVEN_TURN);
            System.out.println("i = " + i);
            monitor.toggleTurn();
        }
    }


}
