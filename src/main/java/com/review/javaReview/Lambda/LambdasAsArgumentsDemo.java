package com.review.javaReview.Lambda;

public class LambdasAsArgumentsDemo {
    static String stringOp(StringFunc sf, String s) {
        return sf.func(s);
    }


    public static void main(String args[]) {
        StringFunc touppercase = (str) -> str.toUpperCase();
        String reversedString = stringOp(touppercase, "ela");
        System.out.println(reversedString);
    }


}
