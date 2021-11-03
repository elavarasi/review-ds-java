package com.review.javaReview.Multithreading.EducativeIO;

public class BadSynchronization {

    public static void main(String args[]) throws InterruptedException {
        BadSynchronization b1 = new BadSynchronization();
        b1.demo();
    }

    Boolean flag = new Boolean(true);

    public void demo() throws InterruptedException {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (flag) {
                    try {
                        while (true) {
                            System.out.println("First thread about to sleep");
                            Thread.sleep(3000);
                            System.out.println("Thread one woke up");
                            System.out.println(flag);
                            flag = true;
                            flag.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(flag.toString());
                flag = false;
                System.out.println(flag);
                System.out.println("Boolean assignment done");
            }
        });


        t1.start();
        Thread.sleep(1000);
        t2.start();

        t1.join();
        t2.join();
    }

}
