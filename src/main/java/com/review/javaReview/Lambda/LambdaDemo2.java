package com.review.javaReview.Lambda;

public class LambdaDemo2 {
    public static void main(String args[]) {
        NumericTest isEven = (int n) -> (n % 2) == 0;

        if (isEven.test(10)) System.out.println("Even");
        if (isEven.test(9)) System.out.println("odd");



    }

}
