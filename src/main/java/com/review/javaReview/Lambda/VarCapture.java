package com.review.javaReview.Lambda;

public class VarCapture {
    public static void main(String args[]) {
        int num;
        num = 10;


        MyFunc func = (n) -> {
            int v = num + n;
            return v;
        };
//        num ++;
    }
}
