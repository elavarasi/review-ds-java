package com.review.javaReview.Lambda;

import java.util.concurrent.Callable;

public class LambdaExpression {
    public static void main(String args[]) throws Exception {
     //   double i = () -> 123.45;

        Callable<Double> doubleCallable = () -> Math.random() * 100;
        Callable<Double> doubleCallable1 = () -> 123.45;
//        (n) -> (n % 2) == 0;
        double i = doubleCallable.call();
        System.out.println(i);

        MyNumber mynum;
        mynum = () -> 123.45;

        System.out.println(mynum.getValue());

//        mynum = () -> "10.0";

        System.out.println(mynum.getValue());

    }
    public class test implements MyNumber {

        @Override
        public double getValue() {
            return 0;
        }
    }

}

