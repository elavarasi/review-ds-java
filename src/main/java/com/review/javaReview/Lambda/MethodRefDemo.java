package com.review.javaReview.Lambda;

public class MethodRefDemo {
    static String stringOp(StringFunc sf, String s) {
        return sf.func(s);
    }

    public static void main(String args[]) {
        String inStr = "Ela is studying";
        String outStr;

        outStr = stringOp(MyStringOps::strReverse, inStr);
        System.out.println(outStr);

    }

}
