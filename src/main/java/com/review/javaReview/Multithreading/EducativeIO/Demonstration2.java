package com.review.javaReview.Multithreading.EducativeIO;

import java.util.Random;
import java.util.concurrent.*;

public class Demonstration2 {
    static Random random = new Random(System.currentTimeMillis());

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        completionServiceExample();
    }

    static void completionServiceExample() throws ExecutionException, InterruptedException {
        class TriviaTask implements Runnable {
            int n;

            public TriviaTask(int n) {
                this.n = n;
            }

            @Override
            public void run() {
                try {
                    Thread.sleep(random.nextInt(101));
                } catch (InterruptedException e) {

                }
            }
        }

        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        ExecutorCompletionService<Integer> service = new ExecutorCompletionService<Integer>(threadPool);

        for (int i = 0; i < 10; i++) {
            service.submit(new TriviaTask(i), new Integer(i));
        }

        // wait for all task to get done
        int count = 10;
        while (count != 0) {
            Future<Integer> f = service.poll();
            if (f != null) {
                System.out.println("Thread" + f.get() + "got done.");
                count --;
            }
        }

        threadPool.shutdown();
    }

}
