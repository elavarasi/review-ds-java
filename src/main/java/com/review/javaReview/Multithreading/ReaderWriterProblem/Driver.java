package com.review.javaReview.Multithreading.ReaderWriterProblem;

import java.util.Date;

public class Driver {
    public static void main(String args[]){
        Reader r1 = new Reader();
        Reader r2 = new Reader();
        Writer w1 = new Writer();

        r1.start();
        w1.start();
        r2.start();


    }

}
