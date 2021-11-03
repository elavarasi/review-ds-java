package com.review.javaReview.Multithreading.EducativeIO;

import jdk.nashorn.internal.codegen.DumpBytecode;

import java.util.concurrent.Executor;

public class ThreadExecutorExample {

    public static void main(String args[]) {
        MyTask task = new MyTask();
        DumbExecutor executor = new DumbExecutor();
        executor.execute(task);

    }

    static class DumbExecutor implements Executor {
        @Override
        public void execute(Runnable command) {
            command.run();
            System.out.println(this.hashCode());
            System.out.println(Thread.currentThread());
            Thread t1 = new Thread(command);
            t1.start();
        }
    }

    static class MyTask implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread());
            System.out.println("Running the task");
        }
    }

}

