package com.review.MultiThreading.BlockingQueue;

public class Test {

    public static void main(String[] args) {
        System.out.println(reverseString("ela"));
    }

    public static String reverseString(String myStr) {
        // Base case
        if (myStr.isEmpty()) {
            return myStr;
        }

        // Recursive case
        else {
            System.out.println(myStr.substring(1));
            return reverseString(myStr.substring(1)) + myStr.charAt(0);
        }
    }
}

