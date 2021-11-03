package com.review.javaReview.Lambda;

public class GenericFunctionalInterfaceDemo {
    public static void main(String args[]) {
        SomeFunc<String> reverseFunc = (str) -> {
            String result = "";
            int i;

            for (i = str.length() - 1; i >=0; i--) {
                result += str.charAt(i);
            }

            return result;
        };

        System.out.println("lambda reverse" + reverseFunc.func("Ela"));

        SomeFunc<Integer> factorial = (n) -> {
            int result = 1;
            for (int i = 1; i < n; i++) {
                result = i * result;
            }
            return result;
        };

        System.out.println("Factorial" + factorial.func(5));

    }
}
